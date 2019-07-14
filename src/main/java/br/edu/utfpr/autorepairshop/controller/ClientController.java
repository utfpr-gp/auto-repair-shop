package br.edu.utfpr.autorepairshop.controller;

import br.edu.utfpr.autorepairshop.model.Address;
import br.edu.utfpr.autorepairshop.model.Credential;
import br.edu.utfpr.autorepairshop.model.dto.AddressDTO;
import br.edu.utfpr.autorepairshop.model.dto.CredentialDTO;
import br.edu.utfpr.autorepairshop.model.mapper.AddressMapper;
import br.edu.utfpr.autorepairshop.model.mapper.ClientMapper;
import br.edu.utfpr.autorepairshop.model.Client;
import br.edu.utfpr.autorepairshop.model.dto.ClientDTO;
import br.edu.utfpr.autorepairshop.model.mapper.CredentialMapper;
import br.edu.utfpr.autorepairshop.model.service.AddressService;
import br.edu.utfpr.autorepairshop.model.service.ClientService;
import br.edu.utfpr.autorepairshop.model.service.CredentialService;
import br.edu.utfpr.autorepairshop.security.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController

@RequestMapping("/clientes")
public class ClientController {

	@Autowired
	ClientService clientService;

	@Autowired
	AddressService addressService;

	@Autowired
	ClientMapper clientMapper;

	@Autowired
	AddressMapper addressMapper;

	@Autowired
	CredentialMapper credentialMapper;

	@Autowired
	CredentialService credentialService;

	@GetMapping
	public ModelAndView index() {
		List<Client> clients = clientService.findAll();


		ArrayList<ClientDTO> clientDTOS = new ArrayList<>();

		int aux = 0;

		for (Client c: clients) {
			clientDTOS.add(clientMapper.toResponseDto(c));
			clientDTOS.get(aux).setCredentialDto(credentialMapper.toDto(c.getCredential()));
			clientDTOS.get(aux).setAddressDto(addressMapper.toDto(c.getAddress()));
			aux++;
		}


		ModelAndView mv = new ModelAndView("client/index");
		mv.addObject("clients", clientDTOS);

		return mv;
	}


	@GetMapping("/novo")
	public ModelAndView showNewClientForm(){

		ModelAndView mv = new ModelAndView("client/form");

		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView showFormForUpdate(@PathVariable("id") Long id){
		ModelAndView mv = new ModelAndView("client/form");

		Optional<Client> client = clientService.findById(id);

		if (!client.isPresent()){
			throw new EntityNotFoundException("O cliente não foi encontrado.");
		}

		ClientDTO clientDTO = clientMapper.toResponseDto(client.get());
		clientDTO.setAddressDto(addressMapper.toDto(client.get().getAddress()));
		clientDTO.setCredentialDto(credentialMapper.toDto(client.get().getCredential()));
		mv.addObject("dto", clientDTO);
		mv.addObject("credentialDto", clientDTO.getCredentialDto());
		mv.addObject("addressDto", clientDTO.getAddressDto());
		return mv;
	}

	@PostMapping
	public ModelAndView save(@Validated ClientDTO clientDto, Errors errors, RedirectAttributes redirectAttributes){

		if(errors.hasErrors()){
			ModelAndView mv = new ModelAndView("client/form");
			mv.addObject("dto", clientDto);
			mv.addObject("errors", errors.getAllErrors());
			return mv;
		}

		if (!clientDto.getCredentialDto().getPassword().equals(clientDto.getCredentialDto().getPasswordConfirmation())){
			ModelAndView mv = new ModelAndView("client/form");
			mv.addObject("dto", clientDto);
			mv.addObject("passwordError", "As senhas são diferentes.");
			return mv;
		}

		Optional<Credential> credentialToVerify = credentialService.findByEmail(clientDto.getCredentialDto().getEmail());

		if(clientDto.getId() == null) {
			if (credentialToVerify.isPresent()){
				ModelAndView mv = new ModelAndView("client/form");
				mv.addObject("dto", clientDto);
				mv.addObject("emailError", "Cliente já cadastrado com esse email.");
				return mv;
			}
		}

		Address address = addressMapper.toEntity(clientDto.getAddressDto());
		Credential credential = credentialMapper.toEntity(clientDto.getCredentialDto());
		Client client =  clientMapper.toEntity(clientDto);

		addressService.save(address);
		client.setAddress(address);

		credential.setRole(RoleEnum.ROLE_CLIENT);
		credentialService.save(credential);
		client.setCredential(credential);

		clientService.save(client);

		redirectAttributes.addFlashAttribute("message", "Cliente salvo com sucesso!");
		return new ModelAndView("redirect:clientes");
	}

	@DeleteMapping("/{id}")
	public ModelAndView delete(@PathVariable Long id, RedirectAttributes redirectAttributes){

		Optional<Client> client = clientService.findById(id);

		if (!client.isPresent()){
			redirectAttributes.addFlashAttribute("message", "Este cliente não foi encontrado!");
			return new ModelAndView("redirect:/clientes");
		}

		clientService.deleteById(id);
		redirectAttributes.addFlashAttribute("message", "Cliente removido com sucesso!");
		return new ModelAndView("redirect:/clientes");
	}

}
