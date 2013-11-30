package pl.rea.transform;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.imageio.ImageIO;

import pl.rea.canonical.ImageCanonical;
import pl.rea.model.Images;

@Stateless
public class ImagesTransform {

	// nie testowane
	public ImageCanonical imagesToImageCanonical(Images images) {
		ImageCanonical imgCanon = new ImageCanonical();
		imgCanon.setId(images.getId());

		InputStream in = new ByteArrayInputStream(images.getImage());
		Image imagePic = null;
		try {
			imagePic = ImageIO.read(in);
		} catch (IOException e) {
			System.out.println("Błąd podczas konwersji obrazu");
		}
		imgCanon.setImage(imagePic);

		return imgCanon;
	}

	// nie testowane
	public Images imageCanonicalToImages(ImageCanonical imgCanon) {
		Images images = new Images();
		images.setId(imgCanon.getId());

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] imageInByte = null;
		try {
			ImageIO.write((RenderedImage) imgCanon.getImage(), "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			System.out.println("Błąd podczas konwersji obrazu");
		}

		images.setImage(imageInByte);

		return images;
	}
	
	//nie testowane
	public List<ImageCanonical> imagesListToCanonicalImageList(List<Images> imgList){
		List<ImageCanonical> imgCanonList = new LinkedList<ImageCanonical>();
		for (Images image : imgList) {
			imgCanonList.add(imagesToImageCanonical(image));
		}
		return imgCanonList;
	}
	
	//nie testowane
	public List<Images> imageCanonicalListToImagesList(List<ImageCanonical> imgCanonList){
		List<Images> imgList = new LinkedList<Images>();
		for (ImageCanonical imgCanon : imgCanonList){
			imgList.add(imageCanonicalToImages(imgCanon));
		}
		return imgList;
	}

}