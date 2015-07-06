package com.sydads.data.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by neilmao on 4/07/2015.
 */
@Entity
@DiscriminatorValue("Pusher")
public class Pusher extends User {

    private double totalRewards;
    private double remainedRewards;

    // as a pusher, I can push some news
    private Set<News> pushedNews;

    public Pusher() {
        super();
        roles.add(Role.Pusher);
    }

    @Column(name = "TotalRewards")
    public double getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(double totalRewards) {
        this.totalRewards = totalRewards;
    }

    @Column(name = "RemainedRewards")
    public double getRemainedRewards() {
        return remainedRewards;
    }

    public void setRemainedRewards(double remainedRewards) {
        this.remainedRewards = remainedRewards;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "UserPushedNews",
            joinColumns = {@JoinColumn(name = "UserId", nullable = false, updatable = false) },
            inverseJoinColumns = {@JoinColumn(name = "NewsId", nullable = false, updatable = false) })
    public Set<News> getPushedNews() {
        return this.pushedNews;
    }

    public void setPushedNews(Set<News> pushedNews) {
        this.pushedNews = pushedNews;
    }
}
