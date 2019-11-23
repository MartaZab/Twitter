package com.example.twitter.Twitter.model.service;


import com.example.twitter.Twitter.model.dto.UserCredentialsDto;
import com.example.twitter.Twitter.model.dto.UserDto;
import com.example.twitter.Twitter.model.entity.User;
import com.example.twitter.Twitter.model.entity.UserCredentials;
import com.example.twitter.Twitter.repository.UserCredentialsRepository;
import com.example.twitter.Twitter.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    public void addUser(UserCredentialsDto userCredentialsDto) {
        UserCredentials userCredentials = mapper.map(userCredentialsDto, UserCredentials.class);
        System.out.println("Zmapowany user: "
                + " " + userCredentials.getName()
                + " " + userCredentials.getSurname());
        userCredentials.setJoinDate(new Date());
        userCredentials.setRole("ROLE_USER");
        userCredentials.setPassword(bCryptPasswordEncoder.encode(userCredentials.getPassword()));

        userCredentialsRepository.save(userCredentials);
    }

    public List<UserDto> getAllUsers() {
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

    //    public void deleteUser(UserDto userDto) {
//        userRepository.delete(userDto.getId());
//    }
    public String getLoggedUserLogin() {
        return ((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    public User getLoggedUser() {
        return userCredentialsRepository.findByLogin(getLoggedUserLogin()).orElseThrow(() -> new RuntimeException("Brk ussera"));
    }

}
