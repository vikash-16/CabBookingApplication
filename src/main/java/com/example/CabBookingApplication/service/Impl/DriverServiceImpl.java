package com.example.CabBookingApplication.service.Impl;

import com.example.CabBookingApplication.dto.DriverRequestDto;
import com.example.CabBookingApplication.model.Driver;
import com.example.CabBookingApplication.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DriverServiceImpl implements DriverService {
    private final List<Driver> driverList;

    public DriverServiceImpl() {
        this.driverList = new ArrayList<>();
    }

    @Override
    public String addDriver(DriverRequestDto driverRequestDto) {
        Driver driver = Driver.ConvertRequestDtoToModel(driverRequestDto);
        driverList.add(driver);
        return "driver added successfully";
    }

    @Override
    public List<Driver> getDrivers() {
        return driverList;
    }
}
