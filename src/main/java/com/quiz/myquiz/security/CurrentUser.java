package com.quiz.myquiz.security;


import com.quiz.myquiz.entity.User;
import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;


@Getter
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private final User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserType().name()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
