package com.example.CabBookingApplication.service.Impl;

import com.example.CabBookingApplication.dto.Location;
import com.example.CabBookingApplication.dto.RideRequest;
import com.example.CabBookingApplication.model.Driver;
import com.example.CabBookingApplication.model.User;
import com.example.CabBookingApplication.service.DriverService;
import com.example.CabBookingApplication.service.RideService;
import com.example.CabBookingApplication.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RideServiceImpl implements RideService {
    private final UserService userService;
    private final DriverService driverService;

    public RideServiceImpl(UserService userService, DriverService driverService) {
        this.userService = userService;
        this.driverService = driverService;
    }

    @Override
    public Object getRides(RideRequest rideRequest) {
        if (ObjectUtils.isEmpty(rideRequest) || rideRequest.getUserName() == null || rideRequest.getSource() == null || rideRequest.getDestination() == null) {
            return "Invalid Request";
        }
        Map<String, User> users = userService.getUsers();
        if (!CollectionUtils.isEmpty(users)) {
            if (!users.containsKey(rideRequest.getUserName())) {
                return "user is not added yet";
            } else if (users.get(rideRequest.getUserName()).getIsAvailable() == false) {
                return "user is already ridding with other driver";
            }
        }
        List<Driver> drivers = driverService.getDrivers();
        List<Driver> driverDetails = drivers.stream()
                .filter(driver -> driver.getIsAvailable())
                .filter(driver -> calculateDistance(driver.getLocation(), rideRequest.getSource()) <= 5)
                .collect(Collectors.toList());
        if(driverDetails.isEmpty()) {
            return "no ride found Since all the driver are more than 5 units away from user";
        }
        return driverDetails;
    }

    @Override
    public void chooseRide(String userName, String driverName) {
        synchronized (this) {
            Map<String, User> users = userService.getUsers();
            List<Driver> drivers = driverService.getDrivers();
            User user = users.get(userName);
            user.setIsAvailable(false);
            user.setRidingWithDriver(driverName);
            for (Driver driver : drivers) {
                if (driver.getDriverDetails().getName().equalsIgnoreCase(driverName)) {
                    driver.setIsAvailable(false);
                    driver.setRideWithUser(userName);
                }
            }
        }
    }

    public double calculateDistance(Location source1, Location source2) {
        // Use Haversine formula or a simple Euclidean distance for demonstration
        double dx = Math.abs(source1.getLatitude() - source2.getLatitude());
        double dy = Math.abs(source1.getLongitude() - source2.getLongitude());
        return Math.sqrt(dx * dx + dy * dy);
    }
}

