package pl.rea.transform;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.rea.canonical.OfferCanonical;
import pl.rea.dao.EstateTypeDao;
import pl.rea.dao.TransactionTypeDao;
import pl.rea.model.Address;
import pl.rea.model.EstateType;
import pl.rea.model.Images;
import pl.rea.model.Offer;
import pl.rea.model.TransactionType;

@Stateless
public class OfferTransform {
	
	@EJB
	EstateTypeDao estateTypeDao;
	
	@EJB
	TransactionTypeDao transactionTypeDao;
	
	@EJB
	ImagesTransform imageTransform;
	
	public Offer offerCanonicalToOffer(OfferCanonical offerCanon){
		Offer offer = new Offer();
		
		offer.setArea(offerCanon.getArea());
		offer.setCreationDate(offerCanon.getCreationDate());
		offer.setDescription(offerCanon.getDescription());
		offer.setFinishDate(offerCanon.getFinishDate());
		offer.setFloor(offerCanon.getFloor());
		offer.setGarage(offerCanon.getGarage());
		offer.setId(offerCanon.getId());
		offer.setPrice(offerCanon.getPrice());
		
		Address address = new Address();
		address.setApartmentNo(offerCanon.getApartmentNo());
		address.setHouseNo(offerCanon.getApartmentNo());
		address.setId(offerCanon.getAddressId());
		address.setPostalCode(offerCanon.getPostalCode());
		address.setStreet(offerCanon.getStreet());
		address.setTown(offerCanon.getTown());
		offer.setAddress(address);
		
		EstateType estateType = estateTypeDao.getEstateTypeByName(offerCanon.getEstateType());
		offer.setEstateType(estateType);
		
		TransactionType transaction = transactionTypeDao.getTransactionTypeByName(offerCanon.getTransactionType());
		offer.setTransactionType(transaction);
		
		List<Images> imgList = imageTransform.imageCanonicalListToImagesList(offerCanon.getImages());
		offer.setImages(imgList);
		
		return offer;
	}

}
