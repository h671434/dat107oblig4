package no.hvl.dat108.participant.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import no.hvl.dat108.participant.registration.RegistrationForm;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public String showLoginForm() {
		return "login";
	}
	
	@PostMapping
	public String tryLogin(@RequestParam String phone,
    		HttpServletRequest request,	RedirectAttributes ra) {

		// ugylid innlogging info? redirect -> /login
		// ny sesjon
		
		return "redirect:participant_list";
	}
	
}
