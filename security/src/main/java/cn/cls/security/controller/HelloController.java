package cn.cls.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
//    @PreAuthorize("hasAuthority('test22')") 不通过
    @PreAuthorize("hasAuthority('system:hello:list')")
    public String hello() {
        return "hello";
    }

}
