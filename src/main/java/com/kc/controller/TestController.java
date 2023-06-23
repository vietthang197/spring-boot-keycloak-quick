package com.kc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class TestController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/test")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'abc', 'def')")
    public String test(HttpServletRequest request) {
        return "index";
    }

    @GetMapping("/admin")
    @PreAuthorize("@oauth2Security.hasResourcePermission(#request, 'Admin Resource', 'urn:servlet-authz:protected:admin:access')")
    public String admin(HttpServletRequest request) {
        return "index";
    }

    @GetMapping("/access-denied")
    public String accessDenied(HttpServletRequest myHttpRequest) {
        return "accessDenied";
    }
}
