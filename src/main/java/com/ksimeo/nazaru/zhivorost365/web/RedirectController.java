package com.ksimeo.nazaru.zhivorost365.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

    @RequestMapping(value = "/calc")
    public String showCalcOffer() {
        return "public/calcoffer";
    }

    @RequestMapping(value = "/calculator")
    public String showCalculator() {
        return "public/calculator";
    }

    @RequestMapping(value = "/gretitude")
    public String showGratitude() {
        return "public/gratitude";
    }

    @RequestMapping(value = "/admin")
    public String adminIndex() {
        return "redirect:/admin/orders";
    }
}
