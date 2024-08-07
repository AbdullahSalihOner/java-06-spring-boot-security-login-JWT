package com.salih.spring.security.login.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8090/api/test

@CrossOrigin(origins = "*", maxAge = 3600)

// @CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/test")
public class TestController {

  //http://localhost:8090/api/test/all
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

    //http://localhost:8090/api/test/user
  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

    //http://localhost:8090/api/test/mod
  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

    //http://localhost:8090/api/test/admin
  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
}
