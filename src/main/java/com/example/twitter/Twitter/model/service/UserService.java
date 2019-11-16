package com.example.twitter.Twitter.model.service;


import com.example.twitter.Twitter.model.dto.UserDto;
import com.example.twitter.Twitter.model.entity.User;
import com.example.twitter.Twitter.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserDto userDto){
        User user = mapper.map(userDto, User.class);
        System.out.println("Zmapowany user: "  + user.getId()
                + " " + user.getName()
                + " " + user.getSurname()
                + " " + user.getJoinDate());
        user.setJoinDate(new Date());
        userRepository.save(user);
    }

    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        for (User u : users) {
            System.out.println("User: " + u.getId()
                    + " " + u.getName()
                    + " " + u.getSurname()
                    + " " + u.getJoinDate());
        }
        return users.stream()
                .map(u -> mapper.map(u, UserDto.class))
                .collect(Collectors.toList());
    }

    public void deleteUser(UserDto userDto){
        userRepository.delete(userDto.getId());
    }


}
