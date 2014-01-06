package pl.rea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity(name = "transactiontype")
public class TransactionType {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transactionTypeSeq") 
  	@SequenceGenerator(name="transactionTypeSeq",sequenceName="transactionTypeSeq", initialValue=50)
	private Long id;
	
	@NotNull
	@Column(unique=true)
	private String transactionType;

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
