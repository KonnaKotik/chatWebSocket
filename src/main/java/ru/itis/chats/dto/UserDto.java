package ru.itis.chats.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor


public class UserDto {

    private Long id;

    private String email;
    private String firstName;
    private String lastName;

}
