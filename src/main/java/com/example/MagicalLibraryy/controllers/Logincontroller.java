package com.example.MagicalLibraryy.controllers;

import com.example.MagicalLibraryy.Repositories.RoleRepository;
import com.example.MagicalLibraryy.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org. springframework. security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@ Controller

public class Logincontroller {
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncodcr;
    @Autowired
    UserRepository userRcpository;
    @Autowired
    RoleRepository RoleRepository;
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/register")
    public String registerGet(){
        return "register";}}