package no.hvl.dat108.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {
	
	@Autowired private ParticipantRepository repo;
	
	public Participant registerParticipant(Participant participant) {	
		return repo.save(participant);
	}
	
	public boolean existsByPhone(String phone) {
		return repo.existsById(phone);
	}
	
}
