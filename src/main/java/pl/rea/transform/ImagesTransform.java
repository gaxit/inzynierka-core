package pl.rea.transform;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;

import pl.rea.canonical.ImageCanonical;
import pl.rea.model.Images;

@Stateless
public class ImagesTransform {

	public ImageCanonical imagesToImageCanonical(Images images) {
		ImageCanonical imgCanon = new ImageCanonical();
		imgCanon.setId(images.getId());
		imgCanon.setImage(images.getImage());
		imgCanon.setFileName(images.getFileName());
		
		return imgCanon;
	}
	
	public Images imageCanonicalToImages(ImageCanonical imgCanon) {
		Images images = new Images();
		images.setId(imgCanon.getId());
		images.setImage(imgCanon.getImage());
		images.setFileName(imgCanon.getFileName());
		
		return images;
	}
	
	public List<ImageCanonical> imagesListToCanonicalImageList(List<Images> imgList){
		if (imgList==null){
			return new LinkedList<ImageCanonical>();
		}
		List<ImageCanonical> imgCanonList = new LinkedList<ImageCanonical>();
		for (Images image : imgList) {
			imgCanonList.add(imagesToImageCanonical(image));
		}
		return imgCanonList;
	}
	
	public List<Images> imageCanonicalListToImagesList(List<ImageCanonical> imgCanonList){
		if (imgCanonList==null){
			return new LinkedList<Images>();
		}
		List<Images> imgList = new LinkedList<Images>();
		for (ImageCanonical imgCanon : imgCanonList){
			imgList.add(imageCanonicalToImages(imgCanon));
		}
		return imgList;
	}

}
