package no.hvl.dat108.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {
	
	@Autowired private ParticipantRepository participantRepo;

}
