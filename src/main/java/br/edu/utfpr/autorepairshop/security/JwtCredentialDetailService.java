package br.edu.utfpr.autorepairshop.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.service.CredentialService;

@Service
public class JwtCredentialDetailService implements UserDetailsService {

	@Autowired
	private CredentialService credentialService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Credential> userOptional = credentialService.findByEmail(username);
		
		if(userOptional.isPresent()) {
			return JwtCredentialFactory.create(userOptional.get());
		}
		
		throw new UsernameNotFoundException("Email não encontrado!");
	}
}
