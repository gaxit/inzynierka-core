package pl.rea.utils;

import javax.ejb.Stateless;

import pl.rea.dao.UserDao;
import pl.rea.model.User;

@Stateless
public class LoggedUserUtils {
	
	private UserDao userDao = new UserDao();
	
	public boolean isUserLogged(String login, String sessionId){
		if (login==null || sessionId==null){
			System.out.println("Dane z argumentów są nullem");
			return false;
		}
		User userDB = userDao.getUserByLogin(login);
		if (userDB==null){
			System.out.println("Nie znalezionon uzytkownika");
			return false;
		}
		if (userDB.getSessionId()==null){
			System.out.println("Uzytkownik nie ma session id");
			return false;
		}
		if (sessionId.equals(userDB.getSessionId())){
			System.out.println("POPRAWNIE uzytkownik jest zalogowany");
			return true;
		}
		System.out.println("Session id różne");
		return false;
	}

}
