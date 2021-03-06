package pl.rea.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity(name="images")
public class Images {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="imagesSeq") 
  	@SequenceGenerator(name="imagesSeq",sequenceName="imagesSeq", initialValue=50)
	private Long id;
	
	@NotNull
	private String fileName;
	
	@NotNull
	private byte[] image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
