package com.sydads.data.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by neilmao on 4/07/2015.
 */
@Entity
@Table(name = "Vendor")
@DiscriminatorValue("Vendor")
public class Vendor extends Pusher {

    private String company;
    private int credit;
    private int pendingCredit;

    // as a vendor, I can publish some advertisements
    private Set<Advertisement> publishedAdvertisements;

    public Vendor() {
        super();
        this.roles.add(Role.Vendor);
        this.credit = 0;
        this.pendingCredit = 0;
    }

    @Column(name = "Company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "Credit")
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Column(name = "PendingCredit")
    public int getPendingCredit() {
        return pendingCredit;
    }

    public void setPendingCredit(int pendingCredit) {
        this.pendingCredit = pendingCredit;
    }

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    public Set<Advertisement> getPublishedAdvertisements() {
        return publishedAdvertisements;
    }

    public void setPublishedAdvertisements(Set<Advertisement> publishedAdvertisements) {
        this.publishedAdvertisements = publishedAdvertisements;
    }
}
