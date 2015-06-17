package com.sydads.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 23/05/15
 */

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false)String error,
                        @RequestParam(value = "logout", required = false)String logout,
                        Model model) {
        String status = "";

        if (logout != null)
            status = "logout";
        if (error != null)
            status = "error";

        model.addAttribute("status", status);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username")String username,
                        @RequestParam(value = "password")String password) {
        return "index";
    }

}
