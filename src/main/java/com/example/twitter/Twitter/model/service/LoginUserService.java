package com.example.twitter.Twitter.model.service;


import com.example.twitter.Twitter.model.dto.LoginUserDto;
import com.example.twitter.Twitter.model.entity.LoginUser;
import com.example.twitter.Twitter.repository.LoginUserRepository;
import com.example.twitter.Twitter.validation.BidingValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class LoginUserService {

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private LoginUserRepository loginUserRepository;
    @Autowired
    private ModelMapper mapper;

    public void addLoginUser (LoginUserDto loginUserDto, BindingResult result) {
        BidingValidator.validate(result);
        System.out.println("Dodajemy uzytkownika " + loginUserDto.getLogin() + " " + loginUserDto.getPassword() + " " + loginUserDto.getRole());
        validateLoginUser(loginUserDto);
        if(checkAuthorities(loginUserDto)){
            System.out.println("Moge dodac uzytkownika");
            String hash = bCryptPasswordEncoder.encode(loginUserDto.getPassword());
            System.out.println("Haslo: " + loginUserDto.getPassword() + " " + " Hash: " + hash + " Matches: " + bCryptPasswordEncoder.matches("test", hash));

            LoginUser loginUser =  mapper.map(loginUserDto, LoginUser.class);
            loginUser.setPassword(hash);
            loginUserRepository.save(loginUser);
        } else {
            throw new RuntimeException("Wrong role!");
        }
    }
    private void validateLoginUser(LoginUserDto loginUserDto){
        if(loginExist(loginUserDto)){
            throw new RuntimeException(" login already exist");
        }
        loginUserRepository.countByLogin(loginUserDto.getLogin());
        if(!checkAuthorities(loginUserDto)){
            throw new RuntimeException("Wrong role!");
        }
    }

    private boolean loginExist (LoginUserDto loginUserDto){
        return loginUserRepository.countByLogin(loginUserDto.getLogin()) >0;
    }


    private boolean checkAuthorities(LoginUserDto loginUserDto) {
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities()
                .toArray()[0]
                .toString()
                .equals(loginUserDto.getRole());
    }
}

