package dat108.oblig4.participant;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import dat108.oblig4.participant.login.LoginForm;
import dat108.oblig4.participant.password.Password;
import dat108.oblig4.participant.password.PasswordService;
import dat108.oblig4.participant.registration.RegistrationForm;

@ExtendWith(MockitoExtension.class) 
public class ParticipantServiceTest {

	private static final List<Participant> MOCK_LIST = List.of(
			new Participant("00000001", new Password("hash", "salt"), "First", "Last", "Male"),
			new Participant("00000002", new Password("hash", "salt"), "First", "Last", "Male"),
			new Participant("00000003", new Password("hash", "salt"), "First", "Last", "Male"),
			new Participant("00000004", new Password("hash", "salt"), "First", "Last", "Male"),
			new Participant("00000005", new Password("hash", "salt"), "First", "Last", "Male"),
			new Participant("00000006", new Password("hash", "salt"), "First", "Last", "Male"));
	
	@Mock private ParticipantRepository mockedParticipantRepo;
	@Mock private PasswordService passwordService;
	@InjectMocks private ParticipantService participantService;
	
	@Test
	public void getAllParticipantsTest() {
		Mockito.when(mockedParticipantRepo.findAll())
				.thenReturn(MOCK_LIST);

		List<Participant> resultat = participantService.getAllParticipants();
		
		Assertions.assertEquals(MOCK_LIST.size(), resultat.size());
		Assertions.assertTrue(resultat.containsAll(MOCK_LIST));
	}
	
	@Test
	public void phoneExistsTest() {
		Mockito.when(mockedParticipantRepo.existsById(Mockito.anyString()))
				.then(i -> MOCK_LIST.stream()
				.anyMatch(p -> p.getPhone().equals(i.getArgument(0))));
		
		Assertions.assertTrue(participantService.phoneExists("00000001"));
		Assertions.assertFalse(participantService.phoneExists("11111110"));
	}
	
	@Test
	public void registerNewParticipantTest() {		
		Mockito.when(mockedParticipantRepo.existsById(Mockito.anyString()))
				.then(i -> MOCK_LIST.stream()
						.anyMatch(p -> p.getPhone().equals(i.getArgument(0))));
		
		Mockito.when(passwordService.encryptPassword(Mockito.nullable(String.class)))
				.then(i -> null);
		
		Mockito.when(mockedParticipantRepo.saveAndFlush(Mockito.any(Participant.class)))
				.then(i -> i.getArgument(0));

		RegistrationForm existingPhone = new RegistrationForm();
		RegistrationForm notExistingPhone = new RegistrationForm();
		
		existingPhone.setPhone("00000002");
		notExistingPhone.setPhone("02932132");
		
		Assertions.assertThrows(
				IllegalArgumentException.class,
				() -> participantService.registerNewParticipant(existingPhone));
		
		Assertions.assertEquals(
				participantService.registerNewParticipant(notExistingPhone).getPhone(),
				"02932132");
	}
	
	@Test
	public void loginAsParticipantTest() {
		Mockito.when(mockedParticipantRepo.findById(Mockito.anyString()))
		.then(i-> MOCK_LIST.stream()
				.filter(p -> p.getPhone().equals(i.getArgument(0)))
				.findFirst());
		
		Mockito.when(passwordService.isCorrectPassword(Mockito.anyString(), Mockito.any(Password.class)))
				.then(i -> i.getArgument(0).equals("pass"));
		
		LoginForm valid = new LoginForm("00000001", "pass");
		LoginForm noUser = new LoginForm("03234322", "pass");
		LoginForm incorrectPassword = new LoginForm("00000001", "incorrect");
		
		Assertions.assertNotNull(participantService.loginAsParticipant(valid));
		Assertions.assertThrows(
				NoSuchElementException.class,
				() -> participantService.loginAsParticipant(noUser));
		
		Assertions.assertThrows(
				IllegalArgumentException.class,
				() -> participantService.loginAsParticipant(incorrectPassword));
	}
	
}
