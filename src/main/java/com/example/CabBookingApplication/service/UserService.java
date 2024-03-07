package com.example.CabBookingApplication.service;

import com.example.CabBookingApplication.dto.UserRequestDto;
import com.example.CabBookingApplication.model.User;

import java.util.Map;

public interface UserService {

    String addUsers(UserRequestDto userRequestDto);

    Map<String, User> getUsers();
}
