package com.sydads.data.model;

import com.sydads.data.Guid;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 8/05/15
 */
@Entity
@Table(name = "Tracker")
public class Tracker extends Guid {

    private Advertisement advertisement;
    private int visit;
    private int maxVisit;
    private int validVisit;
    private int score;
    private Set<Request> requestSet;

}
