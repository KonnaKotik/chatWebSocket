package ru.itis.chats.form;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageForm {

    private Long id;

    private String nameAuthor;

    private String value;

}
