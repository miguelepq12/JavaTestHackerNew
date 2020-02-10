package com.ingerencia.test.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.OneToMany;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostNew {
    private List<Hit> hits;

    private String hitsPerPage;

    private String processingTimeMS;

    private String query;

    private String nbHits;

    private String page;

    private String params;

    private String nbPages;

    private String exhaustiveNbHits;

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

    public String getHitsPerPage() {
        return hitsPerPage;
    }

    public void setHitsPerPage(String hitsPerPage) {
        this.hitsPerPage = hitsPerPage;
    }

    public String getProcessingTimeMS() {
        return processingTimeMS;
    }

    public void setProcessingTimeMS(String processingTimeMS) {
        this.processingTimeMS = processingTimeMS;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getNbHits() {
        return nbHits;
    }

    public void setNbHits(String nbHits) {
        this.nbHits = nbHits;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getNbPages() {
        return nbPages;
    }

    public void setNbPages(String nbPages) {
        this.nbPages = nbPages;
    }

    public String getExhaustiveNbHits() {
        return exhaustiveNbHits;
    }

    public void setExhaustiveNbHits(String exhaustiveNbHits) {
        this.exhaustiveNbHits = exhaustiveNbHits;
    }
}
