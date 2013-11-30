package pl.rea.webservices;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import pl.rea.canonical.OfferCanonical;

@WebService(serviceName = "userService")
@Stateless
public class OfferService {

	public void addOfferToUserFavourites(String login, String sessionId,
			Long offerId, String userLoginToAddOffer) {
		// sprawdzanie, czy dany uzytkownik jest zalogowany
		// sprawdzenie, czy zalogowany jest admin lub login i userLoginToAddOffer jest taki sam
		// pobranie uzytkownika userLoginToAddOffer
		// pobranie oferty o podanym id
		// dodanie do jego listy ulubionych pobranej oferty
		// update uzytkownika
	}

	public List<OfferCanonical> getUserFavouritesOffers(String login,
			String sessionId, String userFavouritesLogin) {
		// sprawdzenie, czy uzytkownik jest zalogowany
		// sprawdzenie, czy zalogowany jest admin albo login i userFavouritesLogin sa takie same
		// pobranie uzytkownika o podanym loginie
		// pobranie jego listy ulubionych
		// konwersja tej listy do listy OfferCanonical - metoda z pakietu
		// transform
		// zwrocenie tej listy

		return null;
	}

	public void deleteOfferFromUserFavourites(String login, String sessionId,
			Long offerId, String userFavouritesLogin) {
		// sprawdzenie, czy uzytkownik jest zalogowany
		// sprawdzenie, czy zalogowany jest admin badz login i userFavouritesLogin sa takie same
		// pobranie uzytkownika o podanym loginie
		// pobranie jego listy ulubionych
		// usuniecie z jego listy ulubionych oferty o podanym id
	}

	public List<OfferCanonical> findOffers(int minPrice, int maxPrice,
			int minArea, int maxArea, String estateType, String town,
			boolean isGarage, int floor) {
		// wyszukanie ofert o podanych kryteriach

		return null;
	}
	
	public List<OfferCanonical> getAllOffers(){
		// pobranie wszystkich ofert dostepnych w bazie
		
		return null;
	}
	
	public OfferCanonical getOffer(Long id){
		// pobranie informacji o jednej ofercie
		
		return null;
	}

}
