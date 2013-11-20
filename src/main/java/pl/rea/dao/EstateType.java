package pl.rea.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.Session;
import org.hibernate.SharedSessionContract;

@Entity(name = "estatetype")
public class EstateType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String estateType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstateType() {
		return estateType;
	}

	public void setEstateType(String estateType) {
		this.estateType = estateType;
	}

	public List<EstateType> listEstateTypes(Session session)
	{
		//returns list of all existing EstateType objects 
		List <EstateType> EstateTypeList;
		EstateTypeList= ((SharedSessionContract) session).createCriteria(EstateType.class).list();
		return EstateTypeList;
	}
	
}
