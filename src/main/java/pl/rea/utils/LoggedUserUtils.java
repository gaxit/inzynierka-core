package pl.rea.utils;

import javax.ejb.Stateless;

import pl.rea.dao.UserDao;
import pl.rea.model.User;

@Stateless
public class LoggedUserUtils {
	
	private UserDao userDao = new UserDao();
	
	public boolean isLogged(String login, String sessionId){
		if (login==null || sessionId==null){
			return false;
		}
		User userDB = userDao.getUserByLogin(login);
		if (userDB==null){
			return false;
		}
		if (userDB.getSessionId()==null){
			return false;
		}
		if (sessionId.equals(userDB.getSessionId())){
			return true;
		}
		return false;
	}
	
	public boolean isUserLogged(String login, String sessionId){
		if (!isLogged(login, sessionId)){
			return false;
		}
		User userDB = userDao.getUserByLogin(login);
		if (userDB==null){
			return false;
		}
		if (userDB.getRole().getRole().equals("Uzytkownik")){
			return true;
		}
		return false;
	}
	
	public boolean isAdminLogged(String login, String sessionId){
		if (!isLogged(login, sessionId)){
			return false;
		}
		User userDB = userDao.getUserByLogin(login);
		if (userDB==null){
			return false;
		}
		if (userDB.getRole().getRole().equals("Administrator")){
			return true;
		}
		return false;
	}

}
