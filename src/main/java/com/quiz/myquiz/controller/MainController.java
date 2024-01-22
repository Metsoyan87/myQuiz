package com.quiz.myquiz.controller;

import com.quiz.myquiz.entity.User;
import com.quiz.myquiz.entity.UserType;
import com.quiz.myquiz.security.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/customLogin")
    public String customLogin() {
        return "customLoginPage";
    }

    @GetMapping("/customSuccessLogin")
    public String customSuccessLogin(@AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null) {
            User user = currentUser.getUser();
            if(user.getUserType() == UserType.TEACHER){
                return "redirect:/admin";
            }else if(user.getUserType() == UserType.STUDENT){
                return "redirect:/";
            }
        }
        return "redirect:/";
    }
}
