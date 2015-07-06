package com.sydads.data.model;

import javax.persistence.*;

/**
 * Created by neilmao on 6/07/2015.
 */
@Entity
@DiscriminatorValue("Pusher")
public class PusherPayment extends Payment {

    private Pusher pusher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PusherId")
    public Pusher getPusher() {
        return pusher;
    }

    public void setPusher(Pusher pusher) {
        this.pusher = pusher;
    }
}
