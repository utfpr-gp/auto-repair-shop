package br.edu.utfpr.autorepairshop.model;


import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "credentials")
@NoArgsConstructor
@Data
public class Credential {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable = false)
	private String email;
	private String password;
	private String role;

	public Credential(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
}
