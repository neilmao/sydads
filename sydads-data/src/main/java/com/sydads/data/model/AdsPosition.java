package com.sydads.data.model;

import com.sydads.data.Guid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by neilmao on 6/07/2015.
 */
@Entity
@Table(name = "AdsPosition")
public class AdsPosition extends Guid {

    private int position;
    private int price;

    @Column(name = "Position")
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Column(name = "Price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
