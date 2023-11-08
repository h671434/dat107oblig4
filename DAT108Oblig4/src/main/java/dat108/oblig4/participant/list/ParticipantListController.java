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
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/participant_list")
public class ParticipantListController {

	@Autowired private ParticipantService participantService;
	
	@GetMapping
	public String getParticipantsList(HttpServletRequest request, Model model) {
		Participant user = (Participant) request.getSession().getAttribute("user");
		
		if(user == null) {
			return "redirect:logout";
		}

		model.addAttribute("currentUserInfo", user.phone + " / " + user.getFullName());
		model.addAttribute("allParticipants", participantService.getAllParticipants());
		
		return "participant_list";
	}

}
