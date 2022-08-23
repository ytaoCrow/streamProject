package com.example.springwebservice.controller;

import com.example.springwebservice.model.entity.User;
import com.example.springwebservice.service.UserService;
import com.example.springwebservice.service.UserStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/stream/users")
public class UserStreamController {

    @Autowired
    private UserService userService;

    @Autowired
    UserStreamService userStreamService;

    // all user display name
    @GetMapping()
    public List<String> getUsersDisplayName(){
        List<String> userResponse = this.userStreamService.getUniqueValueUsersByName();
        return userResponse;
    }


    // get a map contain the format (ID:name)
    @GetMapping("/valueAndName")
    public Map<Integer,String> getValueAndName(){
        Map<Integer,String> userResponse = this.userStreamService.useMap();
        return userResponse;
    }


    // get a data = KZ in one row
    @GetMapping("/name")
    public User getName(){
        Optional<User> userResponse = this.userStreamService.getNameByKZ();
        return userResponse.orElse(null);
    }

    // get all data sorted by age before ID
    @GetMapping("/ageId")
    public List<User> getAgeId(){
        List<User> userResponse = this.userStreamService.getOrderByAgeId();
        return userResponse;
    }



    // get all data to a string format name,age|...
    @GetMapping("/allName")
    public String getAllUsersByName(){
        String userResponse = this.userStreamService.getAllUsersName();
        return userResponse;
    }
}
