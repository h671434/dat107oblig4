package no.hvl.dat108.participant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import no.hvl.dat108.participant.password.Password;
import no.hvl.dat108.participant.password.PasswordService;
import no.hvl.dat108.participant.registration.RegistrationForm;

@Service
public class ParticipantService {
	
	@Autowired ParticipantRepository participantRepo;
	@Autowired PasswordService passwordService;
	
	public boolean phoneExists(String phone) {
		return participantRepo.existsById(phone);
	}
	
	public Participant registerNewParticipant(RegistrationForm registration) {
		Participant participant = buildParticipant(registration);
		
		return participantRepo.saveAndFlush(participant);
	}
	
	private Participant buildParticipant(RegistrationForm registration) {
		Participant p = new Participant();
		
		p.setFirstname(registration.getFirstname());
		p.setLastname(registration.getLastname());
		p.setPhone(registration.getPhone());
		p.setPassword(encryptPassword(registration.getPassword()));
		p.setGender(registration.getGender());
		
		return p;
	}
	
	private Password encryptPassword(String password) {
		String salt = passwordService.generateRandomSalt();
		String hash = passwordService.hashWithSalt(password, salt);
		
		return new Password(hash, salt);
	}
	
	public List<Participant> getAllParticipants() {
		return participantRepo.findAll();
	}
	
}
