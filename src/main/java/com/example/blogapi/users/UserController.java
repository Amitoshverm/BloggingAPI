package com.example.blogapi.users;

import com.example.blogapi.users.dtos.CreateUserDTO;
import com.example.blogapi.users.dtos.LoginUserDTO;
import com.example.blogapi.users.dtos.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService usersService;

    @PostMapping()
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody CreateUserDTO createUserDTO) {
        var savedUser = usersService.createUser(createUserDTO);
        return ResponseEntity
                .created(URI.create("/users/" + savedUser.getId()))
                .body(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> loginUser(@RequestBody LoginUserDTO loginUserDTO) {
        var savedUser = usersService.loginUser(loginUserDTO);
        return ResponseEntity.ok(savedUser);
    }

    @ExceptionHandler (UserService.UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserService.UserNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler (IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentExcept(IllegalArgumentException e) {
        return ResponseEntity.badRequest().build();
    }
}
