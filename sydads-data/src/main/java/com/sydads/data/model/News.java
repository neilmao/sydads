package com.sydads.data.model;

import com.sydads.data.Guid;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
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
    private Admin author;
    private NewsStatus status;
    private Set<Advertisement> advertisements;
    private Set<Pusher> pushers;
    private int requiredViews;
    private int currentViews;
    private double rewardsPerView;
    private Date endDate;

    public News(Date endDate) {
        this.attachedImages = new HashSet<>();
        this.advertisements = new HashSet<>();
        this.status = NewsStatus.Inactive;
        this.createdDate = new Date();
        this.updatedDate = createdDate;
        this.requiredViews = 0;
        this.currentViews = 0;
        this.rewardsPerView = 0D;
        this.endDate = endDate;
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
    public Admin getAuthor() {
        return author;
    }

    public void setAuthor(Admin author) {
        this.author = author;
    }

    @Column(name = "Status")
    public NewsStatus getStatus() {
        return status;
    }

    public void setStatus(NewsStatus status) {
        this.status = status;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "NewsContainedAdvertisement",
            joinColumns = {@JoinColumn(name = "NewsId", nullable = false, updatable = false) },
            inverseJoinColumns = {@JoinColumn(name = "AdvertisementId", nullable = false, updatable = false) })
    public Set<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(Set<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Pusher> getPushers() {
        return pushers;
    }

    public void setPushers(Set<Pusher> pushers) {
        this.pushers = pushers;
    }

    @Column(name = "RequiredViews")
    public int getRequiredViews() {
        return requiredViews;
    }

    public void setRequiredViews(int requiredViews) {
        this.requiredViews = requiredViews;
    }

    @Column(name = "CurrentViews")
    public int getCurrentViews() {
        return currentViews;
    }

    public void setCurrentViews(int currentViews) {
        this.currentViews = currentViews;
    }

    @Column(name = "RewardsPerView")
    public double getRewardsPerView() {
        return rewardsPerView;
    }

    public void setRewardsPerView(double rewardsPerView) {
        this.rewardsPerView = rewardsPerView;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "EndDate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
