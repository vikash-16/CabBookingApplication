package com.example.CabBookingApplication.controller;

import com.example.CabBookingApplication.dto.RideRequest;
import com.example.CabBookingApplication.dto.RideResponseDto;
import com.example.CabBookingApplication.service.RideService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ride")
public class RideController {
    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping("/getRides")
    public ResponseEntity<Object>getRides(RideRequest rideRequest) {
        return new ResponseEntity<>(rideService.getRides(rideRequest), HttpStatus.OK);
    }
    @PatchMapping("/chooseRide")
    public ResponseEntity<String>chooseRide(@RequestParam String userName,
                                            @RequestParam String driverName) {
        rideService.chooseRide(userName,driverName);
        return new ResponseEntity<>("ride chosen",HttpStatus.OK);
    }
}
