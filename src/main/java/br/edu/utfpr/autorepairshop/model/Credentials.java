package br.edu.utfpr.autorepairshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "credentials")
@NoArgsConstructor
@Data
public class Credentials {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_credentials")
	private Long idCredentials;
	private String email;
	private String password;

	public Credentials(Long idCredentials, String email, String password) {
		this.idCredentials = idCredentials;
		this.email = email;
		this.password = password;
	}
	
}
