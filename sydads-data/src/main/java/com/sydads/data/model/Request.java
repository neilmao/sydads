package com.sydads.data.model;

import com.sydads.data.Guid;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 8/05/15
 */
@Entity
@Table(name = "Request")
public class Request extends Guid {

    private String ip;
    private String os;
    private String browser;
    private String source;
    private Date timeStamp;

    private Map<String, String> paramsMap;

    public Request() {
        this.paramsMap = new HashMap<>();
        this.timeStamp = new Date();
    }

    public Request(String params) {

    }
}
