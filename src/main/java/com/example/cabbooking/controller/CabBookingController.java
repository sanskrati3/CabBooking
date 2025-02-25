package com.example.cabbooking.controller;
import com.example.cabbooking.model.Driver;
import com.example.cabbooking.servicetest.DriverService;
import com.example.cabbooking.servicetest.RideService;
import com.example.cabbooking.servicetest.UserService;
import com.example.cabbooking.vo.DriverDetailsVO;
import com.example.cabbooking.vo.LocationDetailsVO;
import com.example.cabbooking.vo.UserDetailsInVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cabbooking")
public class CabBookingController {

    private final RideService rideService;

    private final DriverService driverService;

    private final UserService userService;

    @PostMapping("/add_user")
    public ResponseEntity<String> addUser(@RequestBody UserDetailsInVO userDetails) {
        try {
            userService.addUser(userDetails);
            return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add user", HttpStatus.BAD_REQUEST);
        }
        // How we can return here as response entity.
    }

    @PostMapping("/add_driver")
    public ResponseEntity<String> addDriver(@RequestBody DriverDetailsVO driverDetailsVO) {
        try {
            driverService.addDriver(driverDetailsVO);
        return new ResponseEntity<>("Driver added Successfully",HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Failed to add Driver",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find_ride")
    public ResponseEntity<List<Driver>> findRide(@RequestParam String username, @RequestParam List<Integer> source, @RequestParam List<Integer> destination) {
         try{
           
                List<Driver>availableDrivers =rideService.findRide(username, new LocationDetailsVO(source.get(0), source.get(1)), new LocationDetailsVO(destination.get(0), destination.get(1)));
                if(availableDrivers.isEmpty()) {
                    ResponseEntity<List<Driver>> listResponseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    return listResponseEntity;
                }
                return new ResponseEntity<>(availableDrivers,HttpStatus.OK);
         }
         catch(Exception e){
             return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        // How we return here http request here
    }

    @PostMapping("/choose_ride")
    public synchronized ResponseEntity<String> chooseRide(@RequestParam String userName, @RequestParam String driverName) {
        try {
            rideService.chooseRide(userName, driverName);
            return new ResponseEntity<>("Ride Choosen Succesfully",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Failed to Choose Ride",HttpStatus.BAD_REQUEST);
        }
    }

}

