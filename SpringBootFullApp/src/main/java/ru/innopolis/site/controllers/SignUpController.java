package ru.innopolis.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.innopolis.site.forms.SignUpForm;
import ru.innopolis.site.services.SignUpService;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;


@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PermitAll
    @GetMapping("/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUp";
    }

    @PermitAll
    @PostMapping("/signUp")
    public String signUpUser(@Valid SignUpForm form, BindingResult bindingResult, Model model) {
        // если есть ошибки
        if (bindingResult.hasErrors()) {
            if (bindingResult.getAllErrors()
                    .stream()
                    .anyMatch(error -> error.getCodes()[0].equals("signUpForm.NotSameNames"))) {
                model.addAttribute("namesError", new Object());
            }
            // кладем эту форму с ошибками обратно на страницу
            model.addAttribute("signUpForm", form);
            // возвращаем страницу
            return "signUp";
        }
        // если все ок
        signUpService.signUp(form);
        return "redirect:/signIn";
    }
}
