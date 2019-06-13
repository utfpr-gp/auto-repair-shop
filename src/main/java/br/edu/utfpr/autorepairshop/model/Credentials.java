package br.edu.utfpr.autorepairshop.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "credentials")
@Getter
@Setter
@NoArgsConstructor
@Data
public class Credentials {
	private Long idCredentials;
	private String email;
	private String password;

	public Credentials(Long idCredentials, String email, String password) {
		super();
		this.idCredentials = idCredentials;
		this.email = email;
		this.password = password;
	}
	
}
