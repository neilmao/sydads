package com.sydads.data.model;

import com.sydads.data.Guid;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 8/05/15
 */
@Entity
@Table(name = "Advertisement")
public class Advertisement extends Guid {

    private String content;
    private String title;
    private List<AttachedImage> images;
    private Date createdDate;
    private Date updatedDate;
    private Date expireDate;
    private AdvertisementStatus status;
    private User owner;
    private AdsCategory category;

    protected Advertisement() {
        images = new LinkedList<>();
        createdDate = new Date();
        updatedDate = createdDate;
        status = AdvertisementStatus.Inactive;
    }

    public Advertisement(String title, String content, AdsCategory category, User owner, List<AttachedImage> images) {
        this();
        this.title = title;
        this.content = content;
        this.category = category;
        this.owner = owner;
        this.images = images;
    }

    @Column(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany(mappedBy = "Advertisement", cascade = CascadeType.ALL)
    public List<AttachedImage> getImages() {
        return images;
    }

    public void setImages(List<AttachedImage> images) {
        this.images = images;
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

    @Temporal(TemporalType.DATE)
    @Column(name = "ExpiredDate")
    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Column(name = "Status")
    public AdvertisementStatus getStatus() {
        return status;
    }

    public void setStatus(AdvertisementStatus status) {
        this.status = status;
    }

    @ManyToOne
    @Column(name = "Owner")
    public User getOwner() {
        return owner;
    }

    public void setOwner(User poster) {
        this.owner = poster;
    }

    @Column(name = "Category")
    public AdsCategory getCategory() {
        return category;
    }

    public void setCategory(AdsCategory category) {
        this.category = category;
    }
}
