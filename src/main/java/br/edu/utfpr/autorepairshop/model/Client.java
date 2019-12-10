package br.edu.utfpr.autorepairshop.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@Data
@ToString
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@OneToOne(cascade = CascadeType.ALL)
	private Credential credential;
	@Column(name = "date_birth")
    @Temporal(TemporalType.DATE)
	private Date birthDate;
	private String name;
	private String telephone;

	public Client(Address address, Credential credential, Date birthDate, String name, String telephone) {
		this.address = address;
		this.credential = credential;
		this.birthDate =  birthDate;
		this.name = name;
		this.telephone = telephone;
	}
}
