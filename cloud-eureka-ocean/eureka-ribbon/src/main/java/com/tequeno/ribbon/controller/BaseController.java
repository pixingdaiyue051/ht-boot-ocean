package com.tequeno.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class BaseController {

    @Autowired
    protected RestTemplate restTemplate;
}
