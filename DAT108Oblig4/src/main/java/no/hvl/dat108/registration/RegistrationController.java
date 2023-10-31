package no.hvl.dat108.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.persistence.Embedded;
import jakarta.persistence.Id;
import no.hvl.dat108.participant.Participant;
import no.hvl.dat108.participant.ParticipantService;
import no.hvl.dat108.password.Password;
import no.hvl.dat108.password.PasswordService;

@Controller
public class RegistrationController {

	@Autowired private ParticipantService participantService;
	@Autowired private PasswordService passwordService;
	
	@RequestMapping(value = "/register")
	public String recieveRegistration(Model model, 
			@RequestParam(name = "firstname") String firstname, 
			@RequestParam(name = "lastname") String lastname,
			@RequestParam(name = "phone") String phone,
			@RequestParam(name = "password") String password,
			@RequestParam(name = "repeatPassword") String repeatPassword,
			@RequestParam(name = "gender") String gender) {
		RegistrationData input = new RegistrationData(firstname, lastname, phone, password, repeatPassword, gender);
		RegistrationValidator validator = new RegistrationValidator(input);
		
		if(!validator.isValid() || participantService.existsByPhone(phone)) {
			return "participant_registration";
		} 
		
		Participant newParticipant = registerNewParticipant(input);
		
		model.addAttribute("p", newParticipant);
		
		return "registered";
	}
	
	private Participant registerNewParticipant(RegistrationData input) {
		Participant newParticipant = buildParticipant(input);
		
		return participantService.registerParticipant(newParticipant);
	}
	
	private Participant buildParticipant(RegistrationData input) {
		Participant p = new Participant();
		
		p.setFirstname(input.getFirstname());
		p.setLastname(input.getLastname());
		p.setPhone(input.getPhone());
		p.setGender(input.getGender());
		p.setPassword(passwordService.encryptPassword(input.getPassword()));
		
		return p;
	}
	
}
