package br.edu.utfpr.autorepairshop.model.dto;

import org.springframework.web.bind.annotation.RequestBody;

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
	
	public ImageDTO(@RequestBody ImageDTO dto) {
		this.public_id = dto.getPublic_id();
		this.idversion = dto.getIdversion();
		this.signature = dto.getSignature();
		this.url = dto.getUrl();
	}
	public ImageDTO(String url) {
		this.url = url;
	}
}
