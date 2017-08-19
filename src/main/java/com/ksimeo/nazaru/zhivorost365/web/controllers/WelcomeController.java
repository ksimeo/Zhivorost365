package com.ksimeo.nazaru.zhivorost365.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String showWelcomePage() {
        return "index";
    }

    @RequestMapping(value = "/second", method = RequestMethod.GET)
    public String showSecondPage() {
        return "index2";
    }
}
