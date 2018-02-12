package com.mehuba.nearby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhaoyibin on 18:29 12/02/2018
 */

@Controller
public class HelloController {

    @RequestMapping
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
