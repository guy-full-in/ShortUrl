package ru.kpfu.it.shorturl.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ayrat on 14.06.2014.
 */
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "url_id")
    Long id;

    @Column(name = "url_shortcode")
    String shortCode;

    @Column(name = "url_original_link")
    String originalLink;

    @ManyToOne
    @JoinColumn(name = "url_author_id", referencedColumnName = "user_id")
    User author;

    @Column(name = "url_clicks")
    Integer clicks;

    @Column(name = "url_created_at")
    Date createdAt;

    @Column(name = "url_deleted_at")
    Date deletedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
