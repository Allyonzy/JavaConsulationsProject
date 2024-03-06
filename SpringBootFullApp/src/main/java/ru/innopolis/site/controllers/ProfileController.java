package ru.innopolis.site.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.innopolis.site.security.details.AccountUserDetails;


@Controller
public class ProfileController {
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String getProfilePage(Model model, @AuthenticationPrincipal AccountUserDetails userDetails) {
        model.addAttribute("email", userDetails.getUsername());
        return "profile";
    }
}
