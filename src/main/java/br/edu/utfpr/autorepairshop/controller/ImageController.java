package br.edu.utfpr.autorepairshop.controller;

import java.io.File;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import br.edu.utfpr.autorepairshop.model.dto.ImageDTO;
@Component
public class ImageController {

	private Cloudinary cloudinary;

	private static final List<String> CONTENT_TYPES = Arrays.asList("image/png", "image/jpeg", "image/gif");

	public void init() {
		cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dgmpstiek", "api_key", "911879343538244",
				"api_secret", "BLdryQTE_GkcRNb7QvRwtqpZXG4"));
	}


	public ImageDTO upload(MultipartFile file) {

//		if (file == null) {
//			throw new ImageUploadException("Nenhum arquivo foi enviado. Tente novamente!");
//		}

//		if (!isValidExtension(file)) {
//			throw new InvalidParamsException(
//					"Extensão de arquivo inválido! Por favor, carregue apenas extensões .png, .jpeg ou .gif");
//		}
//
//		if (file != null && file.getContentType() != null && !file.getContentType().toLowerCase().startsWith("image"))
//			throw new InvalidParamsException("Não é uma imagem válida.");

		try {
			File f = Files.createTempFile("temp", file.getOriginalFilename()).toFile();
			file.transferTo(f);

			Map data = cloudinary.uploader().upload(f, ObjectUtils.emptyMap());

			ImageDTO dto = new ImageDTO((String) data.get("url"));
			
			return dto;

		} catch (Exception e) {
			System.out.println();
		}
		return null;
	}

	private boolean isValidExtension(MultipartFile file) {
		String fileContentType = file.getContentType();
		if (!CONTENT_TYPES.contains(fileContentType)) {
			return false;
		}

		return true;
	}

}
