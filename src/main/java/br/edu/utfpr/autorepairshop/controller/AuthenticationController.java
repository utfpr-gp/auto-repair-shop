package br.edu.utfpr.autorepairshop.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.service.CredentialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.utfpr.autorepairshop.security.JwtCredentialDetailService;
import br.edu.utfpr.autorepairshop.model.dto.CredentialDTO;
import br.edu.utfpr.autorepairshop.util.TokenUtil;

import java.util.Optional;

@RequestMapping("/")
@CrossOrigin
@Controller
public class AuthenticationController {

	public static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
		
	@Autowired
	private TokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtCredentialDetailService userDetailsService;

	@Autowired
	private CredentialService credentialService;

	@GetMapping(value = "login")
	public ModelAndView showLogin(@RequestParam(value = "auth", defaultValue = "1") int auth) {
		log.info("Mostrando o index");
		ModelAndView mv = new ModelAndView("login/form");
		if (auth == 0) {
			mv.addObject("message", "Você não esta autenticado");
		}
		return mv;
	}
	
	@PostMapping(value = "login")
	public ModelAndView generateToken(@Validated CredentialDTO dto, Errors errors, HttpServletResponse response) throws AuthenticationException{

		if(errors.hasErrors()){
            ModelAndView mv = new ModelAndView("login/form");
            mv.addObject("dto", dto);
            mv.addObject("errors", errors.getAllErrors());
            mv.addObject("message", "Contém erros no formulário");
            return mv;
        }
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getEmail());
			String token = jwtTokenUtil.generateToken(userDetails);
			Cookie cookieToken = new Cookie("tokenKey", token);
			cookieToken.setMaxAge(60*60*24);
			response.addCookie(cookieToken);

		} catch (BadCredentialsException e) {
			ModelAndView mv = new ModelAndView("login/form");
			mv.addObject("dto", dto);
			mv.addObject("message", "Usuário ou senha invalidos");
			return mv;
		}
		Optional<Credential> o = credentialService.findByEmail(dto.getEmail());
		switch (o.get().getRole()) {
			case ROLE_ADMIN :
				return new ModelAndView("redirect:oficinas");
			case ROLE_MANAGER:
				return new ModelAndView("redirect:funcionarios");
			case ROLE_EMPLOYEE:
				return new ModelAndView("redirect:atendimentos");
		}
		return new ModelAndView("redirect:meu-historico");
	}

	@GetMapping(value = "log-out")
	public ModelAndView logout(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		log.info("Logout");

		Cookie cookieToken = new Cookie("tokenKey", "");
		cookieToken.setMaxAge(0);
		response.addCookie(cookieToken);
		redirectAttributes.addFlashAttribute("message", "Deslogado");
		return new ModelAndView("redirect:login");
	}

}
