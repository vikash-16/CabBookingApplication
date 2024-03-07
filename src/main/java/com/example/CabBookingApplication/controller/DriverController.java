package com.example.CabBookingApplication.controller;

import com.example.CabBookingApplication.dto.DriverRequestDto;
import com.example.CabBookingApplication.service.DriverService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/addDriver")
    public ResponseEntity<String>addDriver(@RequestBody DriverRequestDto driverRequestDto) {
        return new ResponseEntity<>(driverService.addDriver(driverRequestDto), HttpStatus.OK);
    }
    @GetMapping("/getDriver")
    public ResponseEntity<Object>getDriver() {
        return new ResponseEntity<>(driverService.getDrivers(),HttpStatus.OK);
    }
}
