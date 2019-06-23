package br.edu.utfpr.autorepairshop.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@ToString
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;@Temporal(TemporalType.DATE)
	@OneToOne(cascade = CascadeType.PERSIST)
	private Address address;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Credential credential;
	@Column(name = "date_birth")
    @Temporal(TemporalType.DATE)
	private Date dateBirth;
	private String name;
	private String telephone;

	public Client(Address address, Credential credential, Date dateBirth, String name, String telephone) {
		this.address = address;
		this.credential = credential;
		this.dateBirth = dateBirth;
		this.name = name;
		this.telephone = telephone;
	}
}
