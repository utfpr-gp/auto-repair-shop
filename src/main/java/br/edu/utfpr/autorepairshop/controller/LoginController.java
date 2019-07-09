package br.edu.utfpr.autorepairshop.controller;

import javax.servlet.http.Cookie;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.utfpr.autorepairshop.model.dto.ClientDataDTO;
import br.edu.utfpr.autorepairshop.model.dto.JwtAuthenticationDTO;
import br.edu.utfpr.autorepairshop.security.JwtCredentialDetailService;
import br.edu.utfpr.autorepairshop.model.dto.TokenDTO;
import br.edu.utfpr.autorepairshop.util.TokenUtil;

@RequestMapping("/login")
@Controller
public class LoginController {

	public static final Logger log = LoggerFactory.getLogger(LoginController.class);
	private static final String TOKEN_HEADER = "Authorization";
	private static final String BEARER_PREFIX = "Bearer ";
	
	@Autowired
	private AuthenticationManager authenticationManager;
		
	@Autowired
	private TokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtCredentialDetailService userDetailsService;

	@GetMapping
	public ModelAndView showLogin() {
		log.info("Mostrando o index");
		return new ModelAndView("login/form");
	}
	
//	@GetMapping
//	public ModelAndView showIndex() {
//		return new ModelAndView("redirect:login");
//	}
	
	@PostMapping
	public ModelAndView generateToken(@Validated JwtAuthenticationDTO dto, Errors errors, RedirectAttributes redirectAttributes) throws AuthenticationException{	
		log.info("Gerando token parte 1");
		log.info(dto.getEmail() + dto.getPassword());
		
		if(errors.hasErrors()){
            ModelAndView mv = new ModelAndView("login/form");
            mv.addObject("dto", dto);
            mv.addObject("errors", errors.getAllErrors());
            mv.addObject("message", "Contem erros no formulario" + dto.getEmail() + dto.getPassword());
            return mv;
        }
		
		log.info("Gerando token parte 2");
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getEmail());
		String token = jwtTokenUtil.generateToken(userDetails);
		Cookie cookieToken = new Cookie("token", token);
        cookieToken.setMaxAge(60*60*24); //24 hour
	
		return new ModelAndView("index");
	}	

}
