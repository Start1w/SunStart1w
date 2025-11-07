package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson1and2 {

    @RequestMapping("/")
    public String Home() {
        return "/kapian.html";
    }
}
