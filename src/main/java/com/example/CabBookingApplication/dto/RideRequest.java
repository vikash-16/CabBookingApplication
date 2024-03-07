package com.example.CabBookingApplication.dto;

import lombok.Data;

@Data
public class RideRequest {
    private String userName;
    private Location source;
    private Location destination;
}
