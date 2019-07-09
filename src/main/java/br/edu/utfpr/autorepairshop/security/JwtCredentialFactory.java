package br.edu.utfpr.autorepairshop.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.edu.utfpr.autorepairshop.model.Credential;

public class JwtCredentialFactory {
	
	private JwtCredentialFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static JwtCredential create(Credential credential) {
		return new JwtCredential(credential.getId(), credential.getEmail(), credential.getPassword(), 
				mapToGrantedAuthorithies(credential.getRole()));
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorithies(RoleEnum roleEnum){
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(roleEnum.toString()));
		return authorities;
	}

}
