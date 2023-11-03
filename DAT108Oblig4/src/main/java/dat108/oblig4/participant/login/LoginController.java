package dat108.oblig4.participant.login;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dat108.oblig4.participant.Participant;
import dat108.oblig4.participant.ParticipantService;
import dat108.oblig4.participant.registration.RegistrationForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired ParticipantService participantService;
	
	@GetMapping
	public String getLoginForm() {
		return "login";
	}
	
	@PostMapping
	public String recieveLogin(@ModelAttribute("login") @Valid LoginForm login,
    		HttpServletRequest request,	RedirectAttributes ra) {
		if(!participantService.phoneExists(login.getPhone())) {
			return showMessage(ra, "Participant with given phone number does not exist.");
		}
		
		try {
			Participant user = participantService.loginAsParticipant(login);

			LoginUtil.logInUser(request, user);
		} catch(NoSuchElementException | IllegalArgumentException e) {
			return showMessage(ra, e.getMessage());
		}
		
		return "redirect:participant_list";
	}
	
	private String showMessage(RedirectAttributes model, String message) {
		model.addFlashAttribute("loginViewMessage", message);

		return "redirect:login";
	}
	

	
}
