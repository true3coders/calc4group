package org.calc4group.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class IndexController {

    @RequestMapping("/")
    public String indexPage() {
        return "Hello, World!";
    }
}
