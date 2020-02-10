package com.ingerencia.test.controller;

import com.ingerencia.test.JavaTestHackerNewApplication;
import com.ingerencia.test.models.entity.Hit;
import com.ingerencia.test.models.entity.PostInfo;
import com.ingerencia.test.models.entity.PostNew;
import com.ingerencia.test.models.service.IHitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/news")
public class HitController {

    private static final Logger log = LoggerFactory.getLogger(JavaTestHackerNewApplication.class);

    @Autowired
    IHitService service;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = {""})
    public ResponseEntity<?> index() {
        List<Hit> hits = service.findAll();
        Map<String,Object> response= new HashMap<>();
        response.put("feed", PostInfo.debugHit(hits));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Map<String, Object> response=new HashMap<>();

        if (!id.isEmpty()) {
                try {
                    service.delete(id);
                }catch (DataAccessException e) {
                    response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                    return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
                }
        }
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }

    @Scheduled(fixedRateString = "${config.time.delay}")
    public void saveHackerNews() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<PostNew> post = restTemplate.exchange("http://hn.algolia.com/api/v1/search_by_date?query=nodejs", HttpMethod.GET,entity,PostNew.class);

        if(post.getStatusCode().is3xxRedirection())
            post = restTemplate.exchange(post.getHeaders().getLocation(),HttpMethod.GET,entity,PostNew.class);


        service.saveAll(post.getBody().getHits());

        log.info("NOTICIAS GUARDARDAS EN BASE DE DATOS");
    }
}
