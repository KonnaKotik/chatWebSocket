package ru.itis.chats.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.chats.dto.TokenDto;
import ru.itis.chats.form.LoginForm;
import ru.itis.chats.model.user.User;
import ru.itis.chats.repository.UsersRepository;


import javax.persistence.EntityNotFoundException;
import java.util.UUID;


@Service
public class LoginServiceImpl implements LoginService {


    private final UsersRepository usersRepository;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.prefix}")
    private String prefix;


    public LoginServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public TokenDto login(LoginForm loginForm) {
        User user = usersRepository.findOneByEmail(loginForm.getEmail()).orElseThrow(EntityNotFoundException::new);

        if (loginForm.getPassword().equals(user.getHashPassword())) {
            System.out.println(TokenDto.builder().token(getTokenAsString(user)).build());
            return TokenDto.builder().token(getTokenAsString(user)).build();
        } else {
            throw new BadCredentialsException("Incorrect login/password");
        }
    }

    private String getTokenAsString(User user) {
        return prefix + " " + Jwts.builder()
                .claim("role", user.getUserRole().toString())
                .claim("email", user.getEmail())
                .setSubject(user.getId().toString())
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }



}
