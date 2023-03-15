package com.example.blogapi.users;

import com.example.blogapi.security.jwt.JWTService;
import com.example.blogapi.users.dtos.CreateUserDTO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
public class UsersServiceTest {

    @Autowired private UserRepository userRepository;
    private UserService userService;
    private UserService getUserService(){
        if (userService == null) {
            var modelMapper = new ModelMapper();
            var passwordEncoder = new BCryptPasswordEncoder();
            var jwtService = new JWTService();
            userService = new UserService(userRepository, modelMapper, passwordEncoder,jwtService);
        }
        return userService;
    }

    @Test
    public void testCreateUser() {
        var newUser = new CreateUserDTO();
        newUser.setUsername("amitosh09");
        newUser.setEmail("amitosh@email");
        newUser.setPassword("123456");
        var saveUser =  getUserService().createUser(newUser);
        assertNotNull(saveUser);
    }

}
