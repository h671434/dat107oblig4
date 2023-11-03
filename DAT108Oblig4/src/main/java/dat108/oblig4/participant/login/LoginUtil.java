package dat108.oblig4.participant.login;

import dat108.oblig4.participant.Participant;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginUtil {
	
	private static final String USER_ATTRIBUTE_NAME = "user";

	public static void logOutUser(HttpSession session) {
		session.invalidate();
	}
	
	public static void logInUser(HttpServletRequest request, Participant user) {
		request.getSession().setAttribute(USER_ATTRIBUTE_NAME, user);
	}
	
	public static boolean isLoggedIn(HttpSession session) {
		return session.getAttribute(USER_ATTRIBUTE_NAME) != null;
	}
	
}
