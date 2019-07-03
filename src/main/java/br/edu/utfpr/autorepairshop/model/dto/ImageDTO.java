package br.edu.utfpr.autorepairshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class ImageDTO {
	private String public_id ;;
	private String idversion;
	private String signature;
	private String url;
	
	public ImageDTO(String url) {
		this.url = url;
	}
}
