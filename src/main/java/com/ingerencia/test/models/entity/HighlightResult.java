package com.ingerencia.test.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="highlight_results")
public class HighlightResult implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Author author;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Title title;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Url url;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Title story_title;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Url story_url;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private CommentText comment_text;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public Title getStory_title() {
        return story_title;
    }

    public void setStory_title(Title story_title) {
        this.story_title = story_title;
    }

    public Url getStory_url() {
        return story_url;
    }

    public void setStory_url(Url story_url) {
        this.story_url = story_url;
    }

    public CommentText getComment_text() {
        return comment_text;
    }

    public void setComment_text(CommentText comment_text) {
        this.comment_text = comment_text;
    }

    private static final long serialVersionUID = 1L;
}
