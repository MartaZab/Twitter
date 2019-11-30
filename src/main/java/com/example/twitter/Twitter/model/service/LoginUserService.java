package com.example.twitter.Twitter.model.service;


import com.example.twitter.Twitter.model.dto.UserCredentialsDto;
import com.example.twitter.Twitter.model.entity.user.UserCredentials;
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

    public void addLoginUser (UserCredentialsDto userCredentialsDto, BindingResult result) {
        BidingValidator.validate(result);
        System.out.println("Dodajemy uzytkownika " + userCredentialsDto.getLogin() + " " + userCredentialsDto.getPassword() + " " + userCredentialsDto.getRole());
        validateLoginUser(userCredentialsDto);
        if(!checkAuthorities(userCredentialsDto)){
            throw new RuntimeException("Wrong role!");
        }
        System.out.println("Moge dodac uzytkownika");
        String hash = bCryptPasswordEncoder.encode(userCredentialsDto.getPassword());
        System.out.println("Haslo: " + userCredentialsDto.getPassword() + " " + " Hash: " + hash + " Matches: " + bCryptPasswordEncoder.matches("test", hash));
        UserCredentials loginUser =  mapper.map(userCredentialsDto, UserCredentials.class);
        loginUser.setPassword(hash);
        loginUserRepository.save(loginUser);
    }
    private void validateLoginUser(UserCredentialsDto userCredentialsDto){
        if(loginExist(userCredentialsDto)){
            throw new RuntimeException(" login already exist");
        }
        loginUserRepository.countByLogin(userCredentialsDto.getLogin());
        if(!checkAuthorities(userCredentialsDto)){
            throw new RuntimeException("Wrong role!");
        }
    }

    private boolean loginExist (UserCredentialsDto userCredentials){
        return loginUserRepository.countByLogin(userCredentials.getLogin()) >0;
    }


    private boolean checkAuthorities(UserCredentialsDto userCredentials) {
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities()
                .toArray()[0]
                .toString()
                .equals(userCredentials.getRole());
    }
}

