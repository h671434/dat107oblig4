package dat108.oblig4.participant.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dat108.oblig4.participant.registration.RegistrationForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public String showLoginForm() {
		return "login";
	}
	
	@PostMapping
	public String tryLogin(@ModelAttribute("login") LoginForm login,
    		HttpServletRequest request,	RedirectAttributes ra) {

		// ugylid innlogging info? redirect -> /login
		// ny sesjon
		
		return "redirect:participant_list";
	}
	
}
