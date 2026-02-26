package com.kamal.RestAPI.service;

import com.kamal.RestAPI.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService {
     String createUser(UserDTO userDTO);
     UserDTO getUserById(Long id);
     List<UserDTO> getAllUser();
}
