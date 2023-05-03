package com.shopping.dao.impl;

import java.io.IOException;

import javax.servlet.http.Part;

import com.google.api.services.drive.model.File;
import com.shopping.dao.IImageDAO;
import com.shopping.model.Image;
import com.shopping.utils.CreateGoogleFile;

public class ImageDAO extends AbstractDAO<Image> implements IImageDAO{

	@Override
	public int save(Image image) {
		// TODO Auto-generated method stub
		
		Part filePart = image.getFilePart();
		CreateGoogleFile createGoogleFile = new CreateGoogleFile();
		String image_url = "https://drive.google.com/uc?id=14dXGgs4awWVG2GVrVMerugYsOI0RbExU&export=download";
		try {
			File googleFile = createGoogleFile.createGoogleFile(filePart);
			image_url = googleFile.getWebContentLink();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO images(image_url) VALUES (?)";
		return insert(sql, image_url);
	}

}
