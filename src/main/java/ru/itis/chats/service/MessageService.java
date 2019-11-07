package ru.itis.chats.service;





import ru.itis.chats.form.MessageForm;

import java.util.List;

public interface MessageService {

    List<MessageForm> getAllMessage();

    MessageForm save(MessageForm messageForm);
}
