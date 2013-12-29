package pl.rea.transform;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.rea.canonical.ImageCanonical;
import pl.rea.canonical.OfferCanonical;
import pl.rea.dao.EstateTypeDao;
import pl.rea.dao.OfferDao;
import pl.rea.dao.TransactionTypeDao;
import pl.rea.model.Address;
import pl.rea.model.EstateType;
import pl.rea.model.Images;
import pl.rea.model.Offer;
import pl.rea.model.TransactionType;

@Stateless
public class OfferTransform {
	
//	@EJB
	EstateTypeDao estateTypeDao = new EstateTypeDao();
	
//	@EJB
	TransactionTypeDao transactionTypeDao = new TransactionTypeDao();
	
//	@EJB
	ImagesTransform imageTransform = new ImagesTransform();
	
//	@EJB
	OfferDao offerDao = new OfferDao();
	
	//nie testowane
	public Offer offerCanonicalToOffer(OfferCanonical offerCanon){
		Offer offer = new Offer();
		
		offer.setArea(offerCanon.getArea());
		offer.setId(offerCanon.getId());
		offer.setOfferName(offerCanon.getOfferName());
		offer.setDescription(offerCanon.getDescription());
		offer.setFloor(offerCanon.getFloor());
		offer.setGarage(offerCanon.getGarage());
		offer.setPrice(offerCanon.getPrice());
		
		Address address = new Address();
		address.setId(offerCanon.getAddressId());
		address.setApartmentNo(offerCanon.getApartmentNo());
		address.setHouseNo(offerCanon.getApartmentNo());
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
	
	//nie testowane
	public OfferCanonical offerToOfferCanonical(Offer offer){
		OfferCanonical offerCanon = new OfferCanonical();
		
		offerCanon.setId(offer.getId());
		offerCanon.setArea(offer.getArea());
		offerCanon.setOfferName(offer.getOfferName());
		offerCanon.setDescription(offer.getDescription());
		offerCanon.setFloor(offer.getFloor());
		offerCanon.setGarage(offer.isGarage());
		offerCanon.setPrice(offer.getPrice());
		
		offerCanon.setAddressId(offer.getAddress().getId());
		offerCanon.setApartmentNo(offer.getAddress().getApartmentNo());
		offerCanon.setHouseNo(offer.getAddress().getHouseNo());
		offerCanon.setPostalCode(offer.getAddress().getPostalCode());
		offerCanon.setStreet(offer.getAddress().getStreet());
		offerCanon.setTown(offer.getAddress().getTown());
		
		offerCanon.setEstateType(offer.getEstateType().getEstateType());
		
		offerCanon.setTransactionType(offer.getTransactionType().getTransactionType());
		
		List<ImageCanonical> imgCanonList = imageTransform.imagesListToCanonicalImageList(offer.getImages());
		offerCanon.setImages(imgCanonList);
		
		offerCanon.setOwner(offerDao.getOfferOwnerLogin(offer));
		
		return offerCanon;
	}
	
	public List<OfferCanonical> offerListToOfferCanonicalList(List<Offer> offerList){
		List<OfferCanonical> offerCanonList = new LinkedList<OfferCanonical>();
		for (Offer offer : offerList) {
			OfferCanonical offerCanon = offerToOfferCanonical(offer);
			offerCanonList.add(offerCanon);
		}
		return offerCanonList;
	}
	
	public List<Offer> offerCanonicalListToOfferList(List<OfferCanonical> offerCanonList){
		List<Offer> offerList = new LinkedList<Offer>();
		for (OfferCanonical offerCanon : offerCanonList) {
			Offer offer = offerCanonicalToOffer(offerCanon);
			offerList.add(offer);
		}
		return offerList;
	}

}
