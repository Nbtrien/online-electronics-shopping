package com.shopping.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

public class DriveQuickstart {

    private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";

    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    // Directory to store user credentials for this application.
    private static final java.io.File CREDENTIALS_FOLDER //
            = new java.io.File(System.getProperty("user.home"), "credentials");

    private static final String CLIENT_SECRET_FILE_NAME = "client_secret.json";

    //
    // Global instance of the scopes required by this quickstart. If modifying these
    // scopes, delete your previously saved credentials/ folder.
    //
    public static final String DRIVE = "https://www.googleapis.com/auth/drive";
    
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {

        java.io.File clientSecretFilePath = new java.io.File(CREDENTIALS_FOLDER, CLIENT_SECRET_FILE_NAME);

        if (!clientSecretFilePath.exists()) {
            throw new FileNotFoundException("Please copy " + CLIENT_SECRET_FILE_NAME //
                    + " to folder: " + CREDENTIALS_FOLDER.getAbsolutePath());
        }

        // Load client secrets.
        InputStream in = new FileInputStream(clientSecretFilePath);

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
                clientSecrets, SCOPES).setDataStoreFactory(new FileDataStoreFactory(CREDENTIALS_FOLDER))
                        .setAccessType("offline").build();

        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }

    public static void main(String... args) throws IOException, GeneralSecurityException {

        System.out.println("CREDENTIALS_FOLDER: " + CREDENTIALS_FOLDER.getAbsolutePath());

        // 1: Create CREDENTIALS_FOLDER
        if (!CREDENTIALS_FOLDER.exists()) {
            CREDENTIALS_FOLDER.mkdirs();

            System.out.println("Created Folder: " + CREDENTIALS_FOLDER.getAbsolutePath());
            System.out.println("Copy file " + CLIENT_SECRET_FILE_NAME + " into folder above.. and rerun this class!!");
            return;
        }

        // 2: Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        // 3: Read client_secret.json file & create Credential object.
        Credential credential = getCredentials(HTTP_TRANSPORT);

        // 5: Create Google Drive Service.
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential) //
                .setApplicationName(APPLICATION_NAME).build();
        
        String googleFolderIdParent = "1ZyH0kUwgCL-bC3zWxrRBJgiQYewlNwV4";
//        String googleFolderIdParent = null;
        
        String pageToken = null;
        List<File> list = new ArrayList<File>();
        

        String query = null;
        if (googleFolderIdParent == null) {
            query = " mimeType = 'application/vnd.google-apps.folder' " //
                    + " and 'root' in parents";
        } else {
            query = " mimeType = 'application/vnd.google-apps.folder' " //
                    + " and '" + googleFolderIdParent + "' in parents";
        }
        

        do {
            FileList result = service.files().list().setQ(query).setSpaces("drive") //
                    // Fields will be assigned values: id, name, createdTime
                    .setFields("nextPageToken, files(id, name, createdTime)")//
                    .setPageToken(pageToken).execute();
            for (File file : result.getFiles()) {
                list.add(file);
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
        
        for (File folder : list) {
            System.out.println("Folder ID: " + folder.getId() + " --- Name: " + folder.getName());
        }

        // Print the names and IDs for up to 10 files.
//        FileList result = service.files().list().setPageSize(10).setFields("nextPageToken, files(id, name)").execute();
//        List<File> files = result.getFiles();
//        if (files == null || files.isEmpty()) {
//            System.out.println("No files found.");
//        } else {
//            System.out.println("Files:");
//            for (File file : files) {
//                System.out.printf("%s (%s)\n", file.getName(), file.getId());
//            }
//        }
    }
}