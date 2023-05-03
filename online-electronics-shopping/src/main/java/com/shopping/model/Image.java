package com.shopping.model;

import javax.servlet.http.Part;

public class Image extends AbstractModel<Image>{
	private String imageUrl;
	private Part filePart;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String image_url) {
		this.imageUrl = image_url;
	}

	public Part getFilePart() {
		return filePart;
	}

	public void setFilePart(Part filePart) {
		this.filePart = filePart;
	}

	@Override
	public String toString() {
		return "Image [image_url=" + imageUrl + "]";
	}
	
}
