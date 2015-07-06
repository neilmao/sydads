package com.sydads.data.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by neilmao on 4/07/2015.
 */
@Entity
@DiscriminatorValue("Admin")
public class Admin extends Vendor {

    // as an admin, I can publish News
    private Set<News> publishedNews;

    public Admin() {
        super();
        roles.add(Role.Admin);
    }
    
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    public Set<News> getPublishedNews() {
        return publishedNews;
    }

    public void setPublishedNews(Set<News> publishedNews) {
        this.publishedNews = publishedNews;
    }
}
