package com.sydads.data.model;

import com.sydads.data.Guid;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by neilmao on 6/07/2015.
 */
@Entity
@Table(name = "PageView")
public class PageView extends Guid {

    private Date timestamp;
    private String ip;
    private String os;
    private String browser;
    private String token;

    private Tracker tracker;

    public PageView() {
        this.timestamp = new Date();
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Timestamp")
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Column(name = "Ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "Os")
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Column(name = "Browser")
    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @Column(name = "Token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TrackerId")
    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }
}
