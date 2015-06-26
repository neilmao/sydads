package com.sydads.data.model;

import com.sydads.data.Guid;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 8/05/15
 */
@Entity
@Table(name = "AttachedImage")
public class AttachedImage extends Guid {

    private Advertisement advertisement;

    @ManyToOne
    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

}
