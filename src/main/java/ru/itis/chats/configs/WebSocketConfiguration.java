package ru.itis.chats.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import ru.itis.chats.handlers.AuthHandshakeHandler;
import ru.itis.chats.handlers.MessagesWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

    private final MessagesWebSocketHandler messagesWebSocketHandler;

    private final AuthHandshakeHandler authHandshakeHandler;

    @Autowired
    public WebSocketConfiguration(MessagesWebSocketHandler messagesWebSocketHandler, AuthHandshakeHandler authHandshakeHandler) {
        this.messagesWebSocketHandler = messagesWebSocketHandler;
        this.authHandshakeHandler = authHandshakeHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(messagesWebSocketHandler, "/chat")
                .setHandshakeHandler(authHandshakeHandler);
    }
}
