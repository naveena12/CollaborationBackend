package com.niit.collobration.DAO;

import org.springframework.stereotype.Repository;

import com.niit.colloboration.model.FileUpload;
@Repository("fileUploadDAO")
public interface FileUploadDAO {
		 void save(FileUpload fileUpload);
		FileUpload getFile(String username);
	}



