package com.sydads.data;

import com.sydads.Guid;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 8/05/15
 */
@Entity(name = "Tracker")
public class Tracker extends Guid {

    private Advertisement advertisement;
    private int visit;
    private int maxVisit;
    private int validVisit;
    private int score;
    private List<Visit> adsVisitList;

}
