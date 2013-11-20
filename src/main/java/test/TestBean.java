package test;

import javax.faces.bean.ManagedBean;

import java.util.List;


import pl.rea.dao.RoleDao;
import pl.rea.model.Role;

@ManagedBean(name = "testBean")
public class TestBean {

	public void test() {
		RoleDao dao = new RoleDao();
		List<Role> role = dao.getRoleList();
		for (int i = 0; i < role.size(); i++) {
			System.out.println(role.get(i).getRole());
		}
		
		System.out.println("Role by id: " + dao.getRoleById((long)1).getRole());
		
		System.out.println("Role id found by name: " + dao.getRoleByName("ADMIN").getId());
	}

}
