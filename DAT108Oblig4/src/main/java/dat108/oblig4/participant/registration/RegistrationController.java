package dat108.oblig4.participant.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dat108.oblig4.participant.Participant;
import dat108.oblig4.participant.ParticipantService;
import dat108.oblig4.participant.login.LoginUtil;
import dat108.oblig4.participant.password.Password;
import dat108.oblig4.participant.password.PasswordService;
import jakarta.persistence.Embedded;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class RegistrationController {

	@Autowired private ParticipantService participantService;
	
	@GetMapping("/registration")
	public String getRegistrationForm(HttpServletRequest request, Model model) {
		Participant user = (Participant) request.getSession().getAttribute("user");
		
		if(user != null) {
			return "redirect:participant_list";
		}
		
		return "registration";
	}
	
	@PostMapping("/registration")
	public String recieveRegistration(HttpServletRequest request, 
			@ModelAttribute("registration") @Valid RegistrationForm registration,
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return showMessage(model, "Registration details are invalid.");
		}
		
		if(participantService.phoneExists(registration.getPhone())) {
			return showMessage(model, "Participant with given phone number already exists.");
		}
		
		Participant registered = participantService.registerNewParticipant(registration);
		
		LoginUtil.logInUser(request, registered);	

		return showSuccessfulRegistration(model, registered);
	}
	
	private String showMessage(Model model, String message) {
		model.addAttribute("registrationViewMessage", message);
		
		return "registration";
	}
	
	private String showSuccessfulRegistration(Model model, Participant registered)  {
		model.addAttribute("registered", registered);	
		
		return "registration_successful";
	}
	
	 @GetMapping("/registration_successful") 
	 public String getSuccessfulRegistration() {
		 return "registration_successful";
	 }
	
}
