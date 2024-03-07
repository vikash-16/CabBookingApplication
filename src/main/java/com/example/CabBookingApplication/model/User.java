package com.example.CabBookingApplication.model;

import com.example.CabBookingApplication.dto.UserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.StyledEditorKit;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String name;
    private String gender;
    private String age;
    private Boolean isAvailable;
    private String ridingWithDriver;

    public User(String name, String gender, String age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.isAvailable = true;
        this.ridingWithDriver = null;
    }

    public static User convertRequestDtoToModel(UserRequestDto userRequestDto) {
        return new User(userRequestDto.getName(),userRequestDto.getGender(),userRequestDto.getAge());
    }
}
