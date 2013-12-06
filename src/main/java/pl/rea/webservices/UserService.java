package pl.rea.webservices;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.rea.canonical.UserCanonical;
import pl.rea.dao.UserDao;
import pl.rea.model.User;
import pl.rea.transform.UserTransform;
import pl.rea.utils.HibernateUtil;
import pl.rea.utils.LoggedUserUtils;
import pl.rea.utils.SessionIdUtils;

@WebService(serviceName = "userService")
@Stateless
public class UserService {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	private LoggedUserUtils loggedUserUtils = new LoggedUserUtils();
	private UserDao userDao = new UserDao();
	private SessionIdUtils sessionIdUtils = new SessionIdUtils();
	private UserTransform userTransform = new UserTransform();

	// ok
	public boolean isAnybodyLogged(String login, String sessionId) {
		if (login != null && sessionId != null) {
			boolean returnValue = false;
			Session session = null;
			Transaction tx = null;
			try{
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				returnValue = loggedUserUtils.isLogged(login, sessionId);
				
				tx.commit();
			}
			catch(Exception e){
				System.out.println("UserService isAnybodyLogged exception: " + e.getMessage());
				tx.rollback();
			}
			finally {
				if (session != null && session.isOpen()) {
	                session.close();
	            }
			}
			return returnValue;
		}
		return false;
	}
	
	// ok
	public boolean isUserLogged(String login, String sessionId) {
		if (login != null && sessionId != null) {
			boolean returnValue = false;
			Session session = null;
			Transaction tx = null;
			try{
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				returnValue = loggedUserUtils.isUserLogged(login, sessionId);
				
				tx.commit();
			}
			catch(Exception e){
				System.out.println("UserService isUserLogged exception: " + e.getMessage());
				tx.rollback();
			}
			finally {
				if (session != null && session.isOpen()) {
	                session.close();
	            }
			}
			return returnValue;
		}
		return false;
	}
	
	// ok
	public boolean isAdminLogged(String login, String sessionId) {
		if (login != null && sessionId != null) {
			boolean returnValue = false;
			Session session = null;
			Transaction tx = null;
			try{
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				returnValue = loggedUserUtils.isAdminLogged(login, sessionId);
				
				tx.commit();
			}
			catch(Exception e){
				System.out.println("UserService isAdminLogged exception: " + e.getMessage());
				tx.rollback();
			}
			finally {
				if (session != null && session.isOpen()) {
	                session.close();
	            }
			}
			return returnValue;
		}
		return false;
	}
	
	// ok
	public String logIn(String login, String password) {
		// zalogowanie uzytkownika
		// trzeba pobrac uzytkownika z bazy o podanym loginie
		// obliczyc dla takiego loginu sessionId
		// uzupelnic pole sessionId pobranego uzytkownika
		// wywolac metode userDao.updateUser(pobranyUser)
		// zwrocic sessionId - return sessionId

		if (login != null && password != null) {
			Session session = null;
			Transaction tx = null;
			String sessionId = null;
			try{
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				User user = userDao.getUserByLogin(login);
				if (password.equals(user.getPassword())) {
					sessionId = sessionIdUtils.getSessionId(login);
					user.setSessionId(sessionId);
					userDao.updateUser(user);
				}
				tx.commit();
			}
			catch(Exception e){
				System.out.println("UserService logIn exception: " + e.getMessage());
				tx.rollback();
				sessionId = null;
			}
			finally {
				if (session != null && session.isOpen()) {
	                session.close();
	            }
			}
			return sessionId;
		}
		return null;
	}
	
	// ok
	public boolean logOut(String login, String sessionId) {
		// wylogowanie uzytkownika
		// najpierw sprawdzic, czy taki uzytkownik jest zalogowany -
		// LoggedUserUtils.isLogged
		// trzeba pobrac uzytkownika z bazy o podanym loginie
		// ustawic pole sessionId pobranego uzytkownika na null
		// wywolac metode userDao.updateUser(pobranyUser)
		if (login != null && sessionId != null) {
			boolean returnValue = false;;
			Session session = null;
			Transaction tx = null;
			try{
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				User user = userDao.getUserByLogin(login);
				if (sessionId.equals(user.getSessionId())) {
					user.setSessionId(null);
					userDao.updateUser(user);
					returnValue = true;
				}
				tx.commit();
			}
			catch(Exception e){
				System.out.println("UserService logOut exception: " + e.getMessage());
				tx.rollback();
				returnValue = false;
			}
			finally {
				if (session != null && session.isOpen()) {
	                session.close();
	            }
			}
			return returnValue;
		}
		return false;
	}
	
	// ok
	public boolean createUser(UserCanonical user) {
		// dodanie nowego uzytkownika - przez rejestracje juz admina
		// konwersja UserCanonical na User - bazodanowy - metoda z pakietu
		// transform
		// zapisanie uzytkownika do bazy
		if (user != null) {
			boolean returnValue = false;
			Session session = null;
			Transaction tx = null;
			try{
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				User userDB = userTransform.userCanonicalToUser(user);
				userDao.saveUser(userDB);
				tx.commit();
				returnValue = true;
			}
			catch(Exception e){
				System.out.println("UserService createUser exception: " + e.getMessage());
				tx.rollback();
				returnValue = false;
			}
			finally {
				if (session != null && session.isOpen()) {
	                session.close();
	            }
			}
			return returnValue;
		}
		return false;
	}
	
	// ok
	public boolean editUser(String login, String sessionId, UserCanonical user) {
		// edytowanie uzytkownika
		// sprawdzanie, czy uzytkownik o loginie login jest zalogowany
		// sprawdzenie, czy zalogowany jest admin albo login i user_login sa
		// takie same
		// dlatego tak, zeby wykorzystac jedna metode dla edytowania przez
		// admina i przez uzytkownika
		// gdy uzytkownik bedzie edytowal swoje dane, to login i login_z_user
		// beda takie same
		// na poczatku sprawdzanie, czy ten uzytkownik jest zalogowany
		// konwersja UserCanonical na User - bazodanowy - metoda z pakietu
		// transform
		// update uzytkownika w bazie
		if (login != null && sessionId != null && user != null) {
			boolean returnValue = false;
			Session session = null;
			Transaction tx = null;
			try{
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				if (loggedUserUtils.isLogged(login, sessionId)
					&& loggedUserUtils.isAdminLoggedOrLoginsAreTheSame(login, sessionId, user.getLogin())) {
					User userDB = userTransform.userCanonicalToUser(user);
					userDao.updateUser(userDB);
					returnValue = true;
				}
				tx.commit();
			}
			catch(Exception e){
				System.out.println("UserService editUser exception: " + e.getMessage());
				tx.rollback();
				returnValue = false;
			}
			finally {
				if (session != null && session.isOpen()) {
	                session.close();
	            }
			}
			return returnValue;
		}
		return false;
	}

	public boolean deleteUser(String login, String sessionId,
			String userLoginToDelete) {
		// sprawdzenie, czy admin jest zalogowany - moznaby tylko jemu dac prawo
		// do usuwania, co Ty na to?
		// usuniecie uzytkownika o podanym loginie
		if (login != null && sessionId != null && userLoginToDelete != null) {
			Session session = null;
			Transaction tx = null;
			boolean returnValue = false;
			try{
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				if (loggedUserUtils.isAdminLogged(login, sessionId)){
					userDao.deleteUserByLogin(userLoginToDelete);
					returnValue = true;
				}
				tx.commit();
			}
			catch(Exception e){
				System.out.println("UserService deleteUser exception: " + e.getMessage());
				tx.rollback();
				returnValue = false;
			}
			finally {
				if (session != null && session.isOpen()) {
	                session.close();
	            }
			}
			return returnValue;
		}
		return false;
	}

	public UserCanonical getUser(String login, String sessionId,
			String loginUserToGet) {
		// sprawdzenie, czy uzytkownik jest zalogowany
		// sprawdzenie, czy zalogowany jest admin albo login i loginUserToGet sa
		// takie same
		// pobranie i zwrocenie uzytkownika loginUserToGet
		if (login != null && sessionId != null && loginUserToGet != null) {
			Session session = null;
			Transaction tx = null;
			UserCanonical returnUser = null;
			try{
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				if (loggedUserUtils.isLogged(login, sessionId)
						&& loggedUserUtils.isAdminLoggedOrLoginsAreTheSame(login, sessionId, loginUserToGet)) {
					User user = userDao.getUserByLogin(loginUserToGet);
					if (user!=null){
						returnUser = userTransform.userToUserCanonical(user);
					}
				}
				tx.commit();
			}
			catch(Exception e){
				System.out.println("UserService getUser exception: " + e.getMessage());
				tx.rollback();
			}
			finally {
				if (session != null && session.isOpen()) {
		               session.close();
		           }
			}
			return returnUser;
		}
		return null;
	}
	
	
	public List<UserCanonical> getUserList(String login, String sessionId){
		if (login != null && sessionId != null) {
			Session session = null;
			Transaction tx = null;
			List<UserCanonical> userList = null;
			try{
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				// czy admin jest zalogowany
				// pobranie uzytkownikow
				
				tx.commit();
			}
			catch(Exception e){
				System.out.println("UserService getUserList exception: " + e.getMessage());
				tx.rollback();
			}
			finally {
				if (session != null && session.isOpen()) {
		               session.close();
		           }
			}
			return userList;
		}
		return null;
	}

}
