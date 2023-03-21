package com.pichincha.encrypt.rsa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/mvc")
public class MvcController {

    //@ResponseBody
    @GetMapping("saludo")
    public String saludo() {
        return "Hola JOSÉ";
    }
}
