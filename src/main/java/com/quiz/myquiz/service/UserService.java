package com.quiz.myquiz.service;

import com.quiz.myquiz.entity.User;


import java.util.Optional;

public interface UserService {


    Optional<User> findByEmail(String username);


}
