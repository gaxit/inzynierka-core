package pl.rea.utils;

import javax.ejb.Stateless;

import pl.rea.dao.UserDao;
import pl.rea.model.User;

@Stateless
public class LoggedUserUtils {
	
	private UserDao userDao = new UserDao();
	
	public boolean isUserLogged(String login, String sessionId){
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

}
