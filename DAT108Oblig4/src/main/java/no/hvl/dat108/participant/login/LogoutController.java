package no.hvl.dat108.participant.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutController {

	@PostMapping
	public String logOut(HttpSession session, RedirectAttributes ra) {
		// invalider session
		
		return "redirect:login";
	}
	
}
