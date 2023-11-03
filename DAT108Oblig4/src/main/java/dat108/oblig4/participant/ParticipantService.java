package dat108.oblig4.participant;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import dat108.oblig4.participant.login.LoginForm;
import dat108.oblig4.participant.password.Password;
import dat108.oblig4.participant.password.PasswordService;
import dat108.oblig4.participant.registration.RegistrationForm;

@Service
public class ParticipantService {
	
	@Autowired ParticipantRepository participantRepo;
	@Autowired PasswordService passwordService;
	
	public boolean phoneExists(String phone) {
		return participantRepo.existsById(phone);
	}
	
	public Participant registerNewParticipant(RegistrationForm registration) throws IllegalArgumentException {
		if(phoneExists(registration.getPhone())) {
			throw new IllegalArgumentException("Phone " + registration.getPhone() 
					+ " is already registered to another participant.");
		}
		
		Participant participant = buildParticipant(registration);
		
		return participantRepo.saveAndFlush(participant);
	}
	
	private Participant buildParticipant(RegistrationForm registration) {
		Participant p = new Participant();
		
		p.setFirstname(registration.getFirstname());
		p.setLastname(registration.getLastname());
		p.setPhone(registration.getPhone());
		p.setPassword(passwordService.encryptPassword(registration.getPassword()));
		p.setGender(registration.getGender());
		
		return p;
	}
	
	public List<Participant> getAllParticipants() {
		return participantRepo.findAll();
	}
	
	public Participant loginAsParticipant(LoginForm login) throws IllegalArgumentException, NoSuchElementException {
		Optional<Participant> result = participantRepo.findById(login.getPhone());
		
		if(result.isEmpty()) {
			throw new NoSuchElementException("No participant found with phone: "+ login.getPhone());
		}
		
		Participant user = result.get();
		
		if(!passwordService.isCorrectPassword(login.getPassword(), user.getPassword())) {
			throw new IllegalArgumentException("Password is incorrect.");
		}
		
		return user;
		
	}
	
}
