package ru.innopolis.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.annotation.security.PermitAll;


@Controller
public class SignInController {

    @PermitAll
    @GetMapping("/signIn")
    public String getSignInPage() {
        return "signIn";
    }
}
