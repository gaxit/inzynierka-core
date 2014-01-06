package pl.rea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity(name = "estatetype")
public class EstateType {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estateTypeSeq") 
  	@SequenceGenerator(name="estateTypeSeq",sequenceName="estateTypeSeq", initialValue=50)
	private Long id;
	
	@NotNull
	@Column(unique=true)
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

}
