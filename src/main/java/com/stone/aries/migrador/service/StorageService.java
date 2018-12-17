package com.stone.aries.migrador.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public interface StorageService {

	void store(MultipartFile file) throws InvalidFormatException, IOException;

}
