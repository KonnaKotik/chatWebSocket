package ru.itis.chats.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.chats.dto.TokenDto;
import ru.itis.chats.form.LoginForm;
import ru.itis.chats.service.LoginService;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {



    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<TokenDto> login(@Valid @RequestBody LoginForm loginForm) {
       return ResponseEntity.ok().body(loginService.login(loginForm));
    }
}
