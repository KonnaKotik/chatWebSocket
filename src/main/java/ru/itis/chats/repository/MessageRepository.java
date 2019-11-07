package ru.itis.chats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.chats.model.Message;


public interface MessageRepository extends JpaRepository<Message, Long> {

    Message save(Message message);

}
