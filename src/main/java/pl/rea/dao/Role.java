package pl.rea.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.Session;
import org.hibernate.SharedSessionContract;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public List<Role> getUserRoles(Session session)
	{
		//returns a list of all roles
		List <Role> roleList;
	    roleList= ((SharedSessionContract) session).createCriteria(Role.class).list();
	    return roleList;

	}
	
	public Role getUserRole(Session session, Long id)
	{
		//returns role of user with specific id
		Role returnRole = new Role();
		List <Role> roleList;
	    roleList= ((SharedSessionContract) session).createCriteria(Role.class).list();
	    int size = roleList.size();
		if (size>0)
		{
			for (int i=0; i<size; i++){
				Role currentRole = roleList.get(i);
				if (currentRole.getId()==id)
				{
					returnRole=currentRole;
				}
			}
		}
		return returnRole;
	}
	
}
