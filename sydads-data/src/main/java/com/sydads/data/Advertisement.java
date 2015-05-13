package com.sydads.data;

import com.sydads.Guid;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 8/05/15
 */
@Entity(name = "Advertisement")
public class Advertisement extends Guid {

    private String content;
    private String title;
    private List<AttachedImage> images;
    private Date createdDate;
    private Date updatedDate;
    private Date expireDate;
    private AdvertisementStatus status;
    private User poster;
    private AdsCategory category;

}
