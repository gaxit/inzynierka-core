package pl.rea.webservices;

import javax.ejb.Stateless;
import javax.jws.WebService;

import pl.rea.canonical.UserCanonical;

@WebService(serviceName = "userService")
@Stateless
public class UserService {

	public boolean isAnybodyLogged(String login, String sessionId) {
		// sprawdzanie, czy ktokolwiek jest zalogowany
		// wywolanie metody LoggedUserUtils.isLogged
		return false;
	}

	public boolean isUserLogged(String login, String sessionId) {
		// sprawdzanie, czy uzytkownik jest zalogowany
		// wywolanie metody LoggedUserUtils.isUserLogged
		return false;
	}

	public boolean isAdminLogged(String login, String sessionId) {
		// sprawdzanie, czy admin jest zalogowany
		// wywolanie metody LoggedUserUtils.isAdminLogged
		return false;
	}

	public String logIn(String login) {
		// zalogowanie uzytkownika
		// trzeba pobrac uzytkownika z bazy o podanym loginie
		// obliczyc dla takiego loginu sessionId
		// uzupelnic pole sessionId pobranego uzytkownika
		// wywolac metode userDao.updateUser(pobranyUser)
		// zwrocic sessionId - return sessionId

		return null;
	}

	public void logOut(String login, String sessionId) {
		// wylogowanie uzytkownika
		// najpierw sprawdzic, czy taki uzytkownik jest zalogowany -
		// LoggedUserUtils.isLogged
		// trzeba pobrac uzytkownika z bazy o podanym loginie
		// ustawic pole sessionId pobranego uzytkownika na null
		// wywolac metode userDao.updateUser(pobranyUser)
	}

	public void createUser(UserCanonical user) {
		// dodanie nowego uzytkownika - przez rejestracje juz admina
		// konwersja UserCanonical na User - bazodanowy - metoda z pakietu
		// transform
		// zapisanie uzytkownika do bazy
	}

	public void editUser(String login, String sessionId, UserCanonical user) {
		// edytowanie uzytkownika
		// sprawdzanie, czy uzytkownik o loginie login jest zalogowany
		// sprawdzenie, czy zalogowany jest admin albo login i user_login sa takie same
		// dlatego tak, zeby wykorzystac jedna metode dla edytowania przez admina i przez uzytkownika
		// gdy uzytkownik bedzie edytowal swoje dane, to login i login_z_user beda takie same
		// na poczatku sprawdzanie, czy ten uzytkownik jest zalogowany
		// konwersja UserCanonical na User - bazodanowy - metoda z pakietu
		// transform
		// update uzytkownika w bazie
	}

	public void deleteUser(String login, String sessionId,
			String userLoginToDelete) {
		// sprawdzenie, czy admin jest zalogowany - moznaby tylko jemu dac prawo
		// do usuwania, co Ty na to?
		// usuniecie uzytkownika o podanym loginie
	}
	
	public UserCanonical getUser(String login, String sessionId, String loginUserToGet){
		// sprawdzenie, czy uzytkownik jest zalogowany
		// sprawdzenie, czy zalogowany jest admin albo login i loginUserToGet sa takie same
		// pobranie i zwrocenie uzytkownika loginUserToGet
		
		return null;
	}

}
