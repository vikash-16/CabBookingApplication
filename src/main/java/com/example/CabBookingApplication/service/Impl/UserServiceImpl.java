package com.example.CabBookingApplication.service.Impl;

import com.example.CabBookingApplication.dto.UserRequestDto;
import com.example.CabBookingApplication.model.User;
import com.example.CabBookingApplication.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final Map<String,User>users;

    public UserServiceImpl() {
        this.users = new HashMap<>();
    }

    @Override
    public String addUsers(UserRequestDto userRequestDto) {
        User user = User.convertRequestDtoToModel(userRequestDto);
        users.put(user.getName(),user);
        return "user added Successfully";
    }

    @Override
    public Map<String, User> getUsers() {
        return users;
    }
}
