package com.sydads.web.controller;

import com.sydads.data.model.Role;
import com.sydads.data.model.User;
import com.sydads.service.UserService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@RequestParam(value = "type", required = false)String type,
                           Model model) {
        if (StringUtils.isNotBlank(type)) {
            model.addAttribute("type", type);
        }
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam(value = "email", required = true)String email,
                           @RequestParam(value = "password", required = true)String password,
                           Model model) {
        if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(password)) {
            if (userService.checkIfEmailIsUsed(email)) {
                model.addAttribute("status", "used");
            } else {
                User user = userService.register(email, password);
                if (user != null) {
                    model.addAttribute("status", "success");
                } else {
                    model.addAttribute("status", "error");
                }
            }

        } else {
            model.addAttribute("status", "error");
        }

        return "register";
    }
}
