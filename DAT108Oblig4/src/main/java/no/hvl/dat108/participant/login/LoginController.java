package no.hvl.dat108.participant.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public String showLoginForm() {
		return "login";
	}
	
	@PostMapping
	public String tryLogin(@RequestParam String phone, @RequestParam String password,
    		HttpServletRequest request,	RedirectAttributes ra) {
		
		return "redirect:participants_list";
	}
	
}
