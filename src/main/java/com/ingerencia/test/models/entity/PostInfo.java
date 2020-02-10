package com.ingerencia.test.models.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para depurar la informacion que se enviará al front,
 * ya que al parecer solo es poca información la que se utilizará. Se hizo de
 * esta forma y no directamente con Jackson porque datos como title y author
 * estan segmentados.
 */
public class PostInfo {

    public PostInfo(Hit hit) {
        if(hit.getTitle()!=null && !hit.getTitle().isEmpty())
            title=hit.getTitle();
        else
            title=hit.getStory_title();

        if(hit.getUrl()!=null && !hit.getUrl().isEmpty())
            url=hit.getUrl();
        else
            url=hit.getStory_url();

        id=hit.getObjectID();
        createAt=hit.getCreated_at();
        author=hit.getAuthor();
    }

    public PostInfo() {
    }

    private String id;
    private String title;
    private String url;
    private String author;
    @JsonProperty("create_at")
    private String createAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public static List<PostInfo> debugHit(List<Hit> hits){
        List<PostInfo> postInfos=new ArrayList<>();
        for (Hit hit : hits){
            postInfos.add(new PostInfo(hit));
        }

        return postInfos;
    }
}
