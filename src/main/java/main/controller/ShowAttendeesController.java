package main.controller;


import jakarta.servlet.http.HttpSession;
import main.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("showAttendees")
public class ShowAttendeesController {

    @Autowired
    UserService userService;

    @GetMapping
    public String attendees(
            Model model,
            HttpSession session
    ){
        if(session.getAttribute("user") == null){
            return "index";
        }

        else{
            userService.getAllUsers();
            model.addAttribute("users", userService.getAllUsers());
            return "users";
        }
    }





}
