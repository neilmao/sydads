package com.sydads.data.model;

import javax.persistence.*;

/**
 * Created by neilmao on 6/07/2015.
 */
@Entity
@DiscriminatorValue("Vendor")
public class VendorPayment extends Payment {

    private Vendor vendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VendorId")
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
