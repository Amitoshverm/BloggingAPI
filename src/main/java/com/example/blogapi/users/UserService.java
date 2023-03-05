package com.example.blogapi.users;

import com.example.blogapi.users.dtos.CreateUserDTO;
import com.example.blogapi.users.dtos.LoginUserDTO;
import com.example.blogapi.users.dtos.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;



    public UserResponseDTO createUser(CreateUserDTO createUserDTO) {
        // TODO: Encrypt password
        // TODO: check username already exist or not
        // TODO: validate email

        var newUserEntity = modelMapper.map(createUserDTO, UserEntity.class);
        var savedUser = userRepository.save(newUserEntity);
        var userResponseDTO = modelMapper.map(savedUser, UserResponseDTO.class);
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
        // TODO : implement password matching
        return null;
    }
}
