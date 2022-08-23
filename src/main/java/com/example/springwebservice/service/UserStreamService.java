package com.example.springwebservice.service;

import com.example.springwebservice.controller.dto.request.CreateUserRequest;
import com.example.springwebservice.controller.dto.request.UpdateUserRequest;
import com.example.springwebservice.model.UserRepository;
import com.example.springwebservice.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserStreamService {

    List<User> userList;
    @Autowired
    private UserRepository userRepository;

    // all user display name
    public List<String> getUniqueValueUsersByName(){
        List<User> response = userRepository.findAll();

        List<String> dataStream =
                response.stream()
                        .map(User::getName)
                        .distinct()
                        .sorted()
                        .collect(Collectors.toList());
        return dataStream;
    }
    public Map<Integer,String> useMap(){
        List<User> response = userRepository.findAll();

        Map<Integer,String> dataStream =
                response.stream()
                        .collect(Collectors.toMap(u -> u.getId(), u -> u.getName()));

        return dataStream;
    }
    public Optional<User> getNameByKZ(){
        List<User> response = userRepository.findAll();

        String name = "KZ";
        Optional<User> dataStream =
                response.stream()
                        .filter(e -> e.getName().equals(name))
                        .findFirst();

        return dataStream;
    }

    public List<User> getOrderByAgeId() {
        List<User> dataStream =
                        userRepository.findAll()
                        .stream()
                        .sorted(Comparator.comparing(User::getAge)
                        .reversed().thenComparing(User::getId))
                        .collect(Collectors.toList());

        return dataStream;
    }
    public String getAllUsersName() {
        String dataStream = "";
        dataStream = userRepository.findAll()
                                    .stream()
                                    .map(p -> p.getName() + "," + p.getAge()+"  ")
                                    .collect(Collectors.joining("|"+"  "));
        return dataStream;
    }
} // Class end
