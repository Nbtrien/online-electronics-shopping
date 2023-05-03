package com.shopping.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

public class CreateGoogleFile {

	private static String FOLDER_ID = "14d_gzI0neA5EJFw93vqJFEyhv-E1TMJv";

	// PRIVATE!
	private static File _createGoogleFile(String contentType, //
			String customFileName, AbstractInputStreamContent uploadStreamContent) throws IOException {

		File fileMetadata = new File();
		fileMetadata.setName(customFileName);

		List<String> parents = Arrays.asList(FOLDER_ID);
		fileMetadata.setParents(parents);
		//
		Drive driveService = GoogleDriveUtils.getDriveService();

		File file = driveService.files().create(fileMetadata, uploadStreamContent)
				.setFields("id, webContentLink, webViewLink, parents").execute();

		return file;
	}

	// Create Google File from byte[]
	public static File createGoogleFile(String contentType, //
			String customFileName, byte[] uploadData) throws IOException {
		//
		AbstractInputStreamContent uploadStreamContent = new ByteArrayContent(contentType, uploadData);
		//
		return _createGoogleFile(contentType, customFileName, uploadStreamContent);
	}

	// Create Google File from java.io.File
	public static File createGoogleFile(String contentType, //
			String customFileName, java.io.File uploadFile) throws IOException {

		//
		AbstractInputStreamContent uploadStreamContent = new FileContent(contentType, uploadFile);
		//
		return _createGoogleFile(contentType, customFileName, uploadStreamContent);
	}

	// Create Google File from InputStream
	public static File createGoogleFile(String contentType, //
			String customFileName, InputStream inputStream) throws IOException {

		//
		AbstractInputStreamContent uploadStreamContent = new InputStreamContent(contentType, inputStream);
		//
		return _createGoogleFile(contentType, customFileName, uploadStreamContent);
	}

	// Create Google File from Part
	public static File createGoogleFile(Part filePart) throws IOException {
		
		String fileName = getFileName(filePart);
		InputStream fileContent = filePart.getInputStream();
		
		fileName = getRandomFilename(fileName);
		
		return createGoogleFile("image/jpeg", fileName, fileContent);

	}

	public static String getRandomFilename(String filePath) {
		String randomGuid = UUID.randomUUID().toString().replace("-", "");
		String directory = FilenameUtils.getBaseName(filePath);
		String extension = FilenameUtils.getExtension(filePath);
		return String.format("%s%s.%s", directory, randomGuid, extension);
	}

	public static String getFileName(Part part) {
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

    public static void main(String[] args) throws IOException {

        java.io.File uploadFile = new java.io.File("E:/Downloads/laptop.png");

        // Create Google File:
        uploadFile.getName();

        File googleFile = createGoogleFile("image/jpeg",  getRandomFilename(uploadFile.getName()), uploadFile);

        System.out.println("Created Google file!");
        System.out.println("WebContentLink: " + googleFile.getWebContentLink() );
        System.out.println("WebViewLink: " + googleFile.getWebViewLink() );

        System.out.println("Done!");
    }

}