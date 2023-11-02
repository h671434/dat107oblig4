package dat108.oblig4.participant.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dat108.oblig4.participant.Participant;
import dat108.oblig4.participant.ParticipantService;

@Controller
@RequestMapping("/participant_list")
public class ParticipantListController {

	@Autowired ParticipantService participantService;
	
	@GetMapping
	public String getParticipantsList(Model model) {
		
		// hent sesjondata
		// ikke innlogget? redirect -> /login 
		populateList(model);
		
		return "participant_list";
	}
	
	private void populateList(Model model) {
		List<Participant> allParticipants = participantService.getAllParticipants();
		
		model.addAttribute("allParticipants", allParticipants);
	}
 	
	@PostMapping
	public String doSomething() {
		
		// ikke innlogget? redirect -> /login
		// oppdater sesjon?
		
		return "redirect:participant_list";
	}
	

}
