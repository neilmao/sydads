package com.sydads.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 */
@Controller
public class PusherController {

    @RequestMapping(value = "/pusher/index", method = RequestMethod.GET)
    public String pusherHome() {


        return "pusher/home";
    }
}
