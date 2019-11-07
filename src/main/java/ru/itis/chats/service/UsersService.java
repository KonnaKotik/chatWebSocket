package ru.itis.chats.service;


import ru.itis.chats.form.UserCreateForm;

public interface UsersService {

    void signUp(UserCreateForm userCreateForm);
}
