package com.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UIController {

    @RequestMapping("/rules")
    public String rulePage(Map<String, Object> model) {
        return "admin";
    }


}
