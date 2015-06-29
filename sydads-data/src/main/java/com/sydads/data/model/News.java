package com.sydads.data.model;

import com.sydads.data.Guid;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by neilmao on 29/06/2015.
 */
@Entity
@Table(name = "News")
public class News extends Guid {

    private String title;
    private String content;
    private Set<AttachedImage> attachedImages;
    private Date createdDate;
    private Date updatedDate;
    private User author;
    private NewsStatus status;

    public News() {
        status = NewsStatus.Inactive;
        createdDate = new Date();
        updatedDate = createdDate;
    }

    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
    public Set<AttachedImage> getAttachedImages() {
        return attachedImages;
    }

    public void setAttachedImages(Set<AttachedImage> attachedImages) {
        this.attachedImages = attachedImages;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "CreatedDate")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "UpdatedDate")
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AuthorId")
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Column(name = "Status")
    public NewsStatus getStatus() {
        return status;
    }

    public void setStatus(NewsStatus status) {
        this.status = status;
    }
}
