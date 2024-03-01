package ru.innopolis.springbootappexample.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.springbootappexample.model.User;
import ru.innopolis.springbootappexample.services.UsersServices;

import java.util.ArrayList;
import java.util.List;

/**
 * localhost:8080/users
 */
@Controller
@RequiredArgsConstructor
@ToString(includeFieldNames = false)
@RequestMapping("/users")
public class UsersController {

    private final UsersServices usersServices;

    /**
     * HTTP протокол
     * get - получить данные по ссылке
     */
    @GetMapping
    public ResponseEntity<Object> getUsersPage(Model model) {
//        model.addAttribute("users", usersServices.getAll());
//        return "users";
        List<User> users = usersServices.getAll();
        List<JSONPObject> usersJsonList = new ArrayList<>();

        for(User user : users) {
            JSONPObject entity = new JSONPObject("test_user", user);
            usersJsonList.add(entity);
        }

        return new ResponseEntity<Object>(usersJsonList, HttpStatus.OK);

    }

}
