package com.sydads.data.model;

import com.sydads.data.Guid;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by neilmao on 6/07/2015.
 */
@Entity
@Table(name = "Payment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Class")
@DiscriminatorValue("Abstract")
public abstract class Payment extends Guid {

    private double amount;
    private Date date;
    private Admin operator;

    @Column(name = "Amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "Date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AdminId")
    public Admin getOperator() {
        return operator;
    }

    public void setOperator(Admin operator) {
        this.operator = operator;
    }
}
