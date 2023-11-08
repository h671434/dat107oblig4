package main.controller;


import jakarta.servlet.http.HttpSession;
import main.user.PasswordService;
import main.user.User;
import main.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class loginController {

    @Autowired private UserService userService;
    @Autowired private PasswordService passwordService;

    @PostMapping(value = "/login")
    public String login(
            @RequestParam(name = "loginPhone") String phone,
            @RequestParam(name = "loginPassword") String password,
            RedirectAttributes ra,
            HttpSession session
    ){

        User user = userService.findById(phone).orElse(null);
        if(user == null){
            return "redirect:index";
        }


        String inPassEnc = passwordService.hashWithSalt(password, user.getPassword().getSalt());

        if(!inPassEnc.equals(user.getPassword().getHash())){
            return "redirect:index";
        }else {
            session.setAttribute("user", user);
            return "redirect:showAttendees";
        }

    }
}
