package com.stone.aries.migrador.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.stone.aries.migrador.model.Formulario;

public interface StorageService {

	List<Formulario> store(MultipartFile file) throws InvalidFormatException, IOException;

}
