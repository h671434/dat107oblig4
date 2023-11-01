package no.hvl.dat108.participant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParticipantsController {

	@GetMapping("/participants_list")
	public String showParticipantsList() {
		System.out.println("poop");
		return "participants_list";
	}
	
}
