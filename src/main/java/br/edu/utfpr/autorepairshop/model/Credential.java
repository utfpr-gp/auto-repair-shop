package br.edu.utfpr.autorepairshop.model;


import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.utfpr.autorepairshop.security.RoleEnum;
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

	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private RoleEnum role;

	public Credential(String email, String password, RoleEnum role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
}
