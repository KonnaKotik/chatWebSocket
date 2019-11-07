package ru.itis.chats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.chats.form.UserCreateForm;
import ru.itis.chats.service.UsersService;


import javax.validation.Valid;

@RestController
@RequestMapping("/signUp")
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody UserCreateForm userCreateForm) {
        usersService.signUp(userCreateForm);
    }
}
