package pl.rea.transform;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;

import pl.rea.model.EstateType;
import pl.rea.model.Role;
import pl.rea.model.TransactionType;

@Stateless
public class DicsTransform {
	
	public List<String> estateTypeListToStringList(List<EstateType> typeList){
		List<String> stringList = new LinkedList<String>();
		for (EstateType type : typeList) {
			stringList.add(type.getEstateType());
		}
		return stringList;
	}
	
	public List<String> transactionTypeListToStringList(List<TransactionType> transTypeList){
		List<String> stringList = new LinkedList<String>();
		for (TransactionType type : transTypeList) {
			stringList.add(type.getTransactionType());
		}
		return stringList;
	}
	
	public List<String> roleListToStringList(List<Role> roleList){
		List<String> stringList = new LinkedList<String>();
		for (Role role : roleList) {
			stringList.add(role.getRole());
		}
		return stringList;
	}

}
