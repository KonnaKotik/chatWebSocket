package ru.itis.chats.service;


import ru.itis.chats.dto.TokenDto;
import ru.itis.chats.form.LoginForm;
import ru.itis.chats.model.user.User;

public interface LoginService {

    TokenDto login(LoginForm loginForm);

}
