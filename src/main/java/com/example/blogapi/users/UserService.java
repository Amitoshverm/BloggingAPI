package com.example.blogapi.users;

import com.example.blogapi.security.jwt.JWTService;
import com.example.blogapi.users.dtos.CreateUserDTO;
import com.example.blogapi.users.dtos.LoginUserDTO;
import com.example.blogapi.users.dtos.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, JWTService jwtService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public UserResponseDTO createUser(CreateUserDTO createUserDTO) {
        // TODO: Encrypt password ✅
        // TODO: validate email
        // TODO: check username already exist or not

        var newUserEntity = modelMapper.map(createUserDTO, UserEntity.class);
        newUserEntity.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        var savedUser = userRepository.save(newUserEntity);
        var userResponseDTO = modelMapper.map(savedUser, UserResponseDTO.class);
        userResponseDTO.setToken(jwtService.createJWT(savedUser.getId()));
        return userResponseDTO;

         // If we did not have ModelMapper then -
//        var newuserEntity = new UserEntity();
//        newuserEntity.setUsername(createUserDTO.getUsername());
//        newuserEntity.setEmail(createUserDTO.getEmail());
//        newuserEntity.setPassword(createUserDTO.getPassword());
//        var savedUser = userRepository.save(newuserEntity);
//        var userResponseDTO = new UserResponseDTO();
//        userResponseDTO.setUsername(savedUser.getUsername());
//        userResponseDTO.setEmail(savedUser.getEmail());
//        userResponseDTO.setId(savedUser.getId());
//        return userResponseDTO;

    }

    public UserResponseDTO loginUser(LoginUserDTO loginUserDTO){
        var userEntity = userRepository.findByUsername(loginUserDTO.getUsername());
        if (userEntity == null) {
            throw new IllegalArgumentException(loginUserDTO.getUsername());
        }
        // TODO : implement password matching
        var passMatch = passwordEncoder.matches(loginUserDTO.getPassword(), userEntity.getPassword());
        if (!passMatch) {
            throw new IllegalArgumentException("Incorrect Password");
        }
        var userResponseDTO = modelMapper.map(userEntity, UserResponseDTO.class);

        return userResponseDTO;
    }
    public static class UserNotFoundException extends IllegalArgumentException{}
}
