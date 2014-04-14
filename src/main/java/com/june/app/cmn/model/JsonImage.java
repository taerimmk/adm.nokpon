package com.june.app.cmn.model;

import org.springframework.web.multipart.MultipartFile;



public class JsonImage {

    private MultipartFile image;

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

 
}