package br.edu.utfpr.autorepairshop.model;

import java.util.ArrayList;

public enum BrandEnum {
	TOYOTA(1, "TOYOTA"), VOLKSWAGEN(2, "VOLKSWAGEN"), FORD(3, "FORD"), NISSAN(4, "NISSAN"), HYUNDAI(5, "HYUNDAI");

	private Integer code;
	private String description;

	BrandEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public static ArrayList<String> getValues(){
		
		ArrayList<String> descriptions = new ArrayList<>();
		for(BrandEnum brand : BrandEnum.values())
			descriptions.add(brand.description);
		
		return descriptions;
	}
}
