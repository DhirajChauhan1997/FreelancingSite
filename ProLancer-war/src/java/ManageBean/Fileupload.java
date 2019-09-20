package com.catgovind;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.PartialResponseWriter;
import javax.servlet.http.Part;
@ManagedBean
@ViewScoped
public class Fileupload {

	private Part uploadedFile;
	private String folder = "c:\\files";

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	
//	public void saveFile(){
//		
//		try (InputStream input = uploadedFile.getInputStream()) {
//			String fileName = uploadedFile.getSubmittedFileName();
//	        Files.copy(input, new File(folder, fileName).toPath());
//	    }
//	    catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	}
	
}
