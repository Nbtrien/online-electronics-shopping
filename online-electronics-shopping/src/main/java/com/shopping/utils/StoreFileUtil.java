package com.shopping.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
maxFileSize = 1024 * 1024 * 50, // 50 MB
maxRequestSize = 1024 * 1024 * 100)
public class StoreFileUtil {
	private HttpServletRequest req;
	private static final String UPLOAD_DIR = "uploads";

	public StoreFileUtil(HttpServletRequest req) {
		super();
		this.req = req;
	}
	
	public String storeFile() {
		String applicationPath = req.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        
        String fileName = null;
        String img_URL = null;
        
        try {
			for (Part part : req.getParts()) {
				fileName = getFileName(part);
//            part.write(uploadFilePath + File.separator + fileName);
				
				File uploads = new File(uploadFilePath);
				File f = new File(fileName);
			    File file = new File(uploads, f.getName());
			    
			    try (InputStream input = part.getInputStream()) {
			        Files.copy(input, file.toPath());
			        img_URL = file.getAbsolutePath();
			    } catch (Exception e){

			    }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        img_URL = img_URL.replaceAll("\\\\", "/");
        return img_URL;
		
	}
	
	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
//		System.out.println("content-disposition header= " + contentDisp);
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}
	
}
