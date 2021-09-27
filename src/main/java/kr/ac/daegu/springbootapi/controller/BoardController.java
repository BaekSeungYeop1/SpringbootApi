package kr.ac.daegu.springbootapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @RequestMapping(value = "/")
    public String rootTest() throws Exception {
        return "hello!";
    }
}
