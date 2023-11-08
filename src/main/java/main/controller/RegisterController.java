package main.controller;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.user.Password;
import main.user.PasswordService;
import main.user.UserService;
import main.raw.RawInput;
import main.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordService passwordService;


    @RequestMapping
    public String init() {
        return "index";
    }

    @GetMapping(value = "/register")
    public String getRegisterConfirmation(
            HttpSession session
    ) {
        if(session.getAttribute("user") == null){
            return "index";
        }
        return "register";
    }

    @GetMapping(value = "/index")
    public String wrongIn() {
        return "index";
    }

    @PostMapping("/register")
    public String addUser(
            @Valid @ModelAttribute("person") RawInput rawInput,
            BindingResult bindingResult,
            RedirectAttributes ra,
            HttpSession session
            ){

        boolean equalPass = rawInput.getPassword().equals(rawInput.getConfirmPassword());

        if(bindingResult.hasErrors() || !equalPass){

            String errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .reduce("", (e, f) -> e + f + "<br>");
            errors = equalPass ? errors : errors + " the passwords are not equal";
            //dunno if errors should be added here
            System.out.println(errors);
            ra.addFlashAttribute("errors", "unable to register");
            return "redirect:index";
        }

        Password password = passwordService.encryptPassword(rawInput.getPassword());

        User u = new User(rawInput, password);
        session.setAttribute("user", u);

        userService.registerUser(u);
        System.out.println(u);
        ra.addFlashAttribute("user", u);

        return "redirect:register";
    }


}

