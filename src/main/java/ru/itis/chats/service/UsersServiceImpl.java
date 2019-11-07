package ru.itis.chats.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.stereotype.Service;
import ru.itis.chats.form.UserCreateForm;
import ru.itis.chats.mapper.UserMapper;
import ru.itis.chats.model.user.User;
import ru.itis.chats.repository.UsersRepository;


@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;




    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, UserMapper userMapper) {
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void signUp(UserCreateForm userCreateForm) {
        if(!usersRepository.existsByEmail(userCreateForm.getEmail())) {
            User user = userMapper.convertCreateFormToModel(userCreateForm);
            usersRepository.save(user);
        } else {
            throw new BadCredentialsException("Login is already used");
        }
    }
}
