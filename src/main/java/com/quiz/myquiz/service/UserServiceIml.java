package com.quiz.myquiz.service;

import com.quiz.myquiz.entity.User;
import com.quiz.myquiz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceIml implements UserService {

    private final UserRepository userRepository;


    @Override
    public Optional<User> findByEmail(String username) {
        return Optional.empty();
    }
}

