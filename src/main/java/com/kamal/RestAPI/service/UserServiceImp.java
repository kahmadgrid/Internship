package com.kamal.RestAPI.service;

import com.kamal.RestAPI.dto.UserDTO;
import com.kamal.RestAPI.entity.User;
import com.kamal.RestAPI.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @Override
    public String createUser(UserDTO userDTO) {
        User user = mapToEntity(userDTO);
        userRepo.save(user);
        UserDTO curr = mapToDTO(user);
        return "Success!\nThe user " + curr.getName() + " is added with id: " + curr.getId();
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private User mapToEntity(UserDTO dto){
            User user = new User();
            user.setId(dto.getId());
            user.setName(dto.getName());
            user.setSalary(dto.getSalary());
            user.setAddress(dto.getAddress());
            return user;
    }

    private UserDTO mapToDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSalary(user.getSalary());
        dto.setAddress(user.getAddress());
        return dto;
    }

}
