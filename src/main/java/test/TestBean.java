package test;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import java.util.Date;
import java.util.List;
















import pl.rea.dao.EstateTypeDao;
import pl.rea.dao.OfferDao;
import pl.rea.dao.RoleDao;
import pl.rea.dao.TransactionTypeDao;
import pl.rea.dao.UserDao;
import pl.rea.model.Address;
import pl.rea.model.EstateType;
import pl.rea.model.Offer;
import pl.rea.model.Role;
import pl.rea.model.TransactionType;
import pl.rea.model.User;
import pl.rea.utils.LoggedUserUtils;
import pl.rea.webservices.DicsService;

@ManagedBean(name = "testBean")
public class TestBean {

	@EJB
	private RoleDao roleDao;
	
	@EJB
	private EstateTypeDao estateTypeDao;
	
	@EJB
	private TransactionTypeDao transTypeDao;
	
	@EJB
	private UserDao userDao;
	
	@EJB
	private OfferDao offerDao;
	
//	@EJB
//	private DicsService dicsService;
	private DicsService dicsService = new DicsService();
	
	private LoggedUserUtils loggedUserUtils = new LoggedUserUtils();
	
	public String test() {
		System.out.println("Test bean start");
//		List<String> transTypeList = dicsService.getRoleList();
//		for (String stringg : transTypeList) {
//			System.out.println(stringg);
//		}
//		
//		System.out.println("System time: " + System.currentTimeMillis());
		
		System.out.println("Uzytkownik zalogowany?: " + loggedUserUtils.isUserLogged("login3", "sessionid1"));
		
		
		return null;
	}

}
