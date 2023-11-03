package dat108.oblig4.participant.login;

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
		LoginUtil.logOutUser(session);
		
		ra.addFlashAttribute("loginViewMessage", "You are logged out");

		return "redirect:login";
	}
	
}
