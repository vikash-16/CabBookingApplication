package com.example.CabBookingApplication.dto;

import lombok.Data;

@Data
public class RideResponseDto {
    private String DriverName;
    private Boolean isAvailable;
}
