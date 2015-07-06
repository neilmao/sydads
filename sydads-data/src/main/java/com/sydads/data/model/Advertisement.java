package com.sydads.data.model;

import com.sydads.data.Guid;

import javax.persistence.*;
import java.util.*;

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
    private Set<AttachedImage> images;
    private Date createdDate;
    private Date updatedDate;
    private Date expireDate;
    private AdvertisementStatus status;
    private Vendor vendor;
    private AdsCategory category;
    private Set<News> newsContainers;

    protected Advertisement() {
        this.images = new HashSet<>();
        this.createdDate = new Date();
        this.updatedDate = createdDate;
        this.status = AdvertisementStatus.Inactive;
    }

    public Advertisement(String title, String content, AdsCategory category, Vendor vendor, Set<AttachedImage> images) {
        this();
        this.title = title;
        this.content = content;
        this.category = category;
        this.vendor = vendor;
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

    @OneToMany(mappedBy = "advertisement", cascade = CascadeType.ALL)
    public Set<AttachedImage> getImages() {
        return images;
    }

    public void setImages(Set<AttachedImage> images) {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VendorId")
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Category")
    public AdsCategory getCategory() {
        return category;
    }

    public void setCategory(AdsCategory category) {
        this.category = category;
    }

    @ManyToMany(mappedBy = "advertisements", fetch = FetchType.LAZY)
    public Set<News> getNewsContainers() {
        return newsContainers;
    }

    public void setNewsContainers(Set<News> newsContainers) {
        this.newsContainers = newsContainers;
    }
}
