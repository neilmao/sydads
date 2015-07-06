package com.sydads.data.model;

import com.sydads.data.Guid;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 8/05/15
 */
@Entity
@Table(name = "Tracker")
public class Tracker extends Guid {

    private News news;
    private Pusher pusher;
    private int noOfValidViews;
    private Set<PageView> pageViews;

    public Tracker() {
        this.pageViews = new HashSet<>();
        this.noOfValidViews = 0;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NewsId")
    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PusherId")
    public Pusher getPusher() {
        return pusher;
    }

    public void setPusher(Pusher pusher) {
        this.pusher = pusher;
    }

    @Column(name = "NoOfValidViews")
    public int getNoOfValidViews() {
        return noOfValidViews;
    }

    public void setNoOfValidViews(int noOfValidViews) {
        this.noOfValidViews = noOfValidViews;
    }

    @OneToMany(mappedBy = "tracker", cascade = CascadeType.ALL)
    public Set<PageView> getPageViews() {
        return pageViews;
    }

    public void setPageViews(Set<PageView> pageViews) {
        this.pageViews = pageViews;
    }
}
