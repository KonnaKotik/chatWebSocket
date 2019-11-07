package ru.itis.chats.model.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.chats.model.Message;


import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
@Table(name = "chat_user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String hashPassword;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<Message> messages;


    @Enumerated(value = EnumType.STRING)
    private UserState userState;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;


}
