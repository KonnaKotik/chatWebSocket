package ru.itis.chats.mapper;

import org.springframework.stereotype.Component;
import ru.itis.chats.dto.UserDto;
import ru.itis.chats.form.UserCreateForm;
import ru.itis.chats.model.user.User;
import ru.itis.chats.model.user.UserRole;
import ru.itis.chats.model.user.UserState;

@Component
public class UserMapper {

    public User convertCreateFormToModel (UserCreateForm userCreateForm) {
        return User.builder()
                .email(userCreateForm.getEmail())
                .hashPassword(userCreateForm.getPassword())
                .firstName(userCreateForm.getFirstName())
                .lastName(userCreateForm.getLastName())
                .userRole(UserRole.USER)
                .userState(UserState.ACTIVE)
                .build();

    }

    public UserDto convertModelToDto(User model) {
        return UserDto.builder()
                .id(model.getId())
                .email(model.getEmail())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
    }

    public User convertDtoToModel(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();
    }
}

