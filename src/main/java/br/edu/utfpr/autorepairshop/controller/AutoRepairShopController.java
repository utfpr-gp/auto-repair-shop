package br.edu.utfpr.autorepairshop.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import br.edu.utfpr.autorepairshop.model.AutoRepairShop;
import br.edu.utfpr.autorepairshop.model.dto.AutoRepairShopDTO;
import br.edu.utfpr.autorepairshop.model.dto.ImageDTO;
import br.edu.utfpr.autorepairshop.model.mapper.AutoRepairShopMapper;
import br.edu.utfpr.autorepairshop.model.service.AutoRepairShopService;
import br.edu.utfpr.autorepairshop.util.ImageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/oficinas")
@Controller

public class AutoRepairShopController {
	@Autowired
	private AutoRepairShopMapper autoRepairShopMapper;

	@Autowired
	private AutoRepairShopService autoRepairShopService;
	
	@Autowired
	ImageController ImageController;

	@GetMapping
	public ModelAndView index() {

		List<AutoRepairShop> auto = autoRepairShopService.findAll();

		List<AutoRepairShopDTO> autoDTOs = auto.stream().map(s -> autoRepairShopMapper.toResponseDto(s))
				.collect(Collectors.toList());

		ModelAndView mv = new ModelAndView("auto-repair-shop/index");
		mv.addObject("autoRepairShops", autoDTOs);

		return mv;
	}

	@GetMapping("/novo")
	public ModelAndView showForm() {
		ModelAndView mv = new ModelAndView("auto-repair-shop/form");
		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView showFormForUpdate(@PathVariable("id") Long id) {

		ModelAndView mv = new ModelAndView("auto-repair-shop/edit");

		Optional<AutoRepairShop> optionalAutoRepairShop = autoRepairShopService.findById(id);

		if (!optionalAutoRepairShop.isPresent()) {
			throw new EntityNotFoundException("A oficina não foi encontrada pelo id informado.");
		}

		AutoRepairShopDTO autoRepairShopDTO = autoRepairShopMapper.toResponseDto(optionalAutoRepairShop.get());
		mv.addObject("dto", autoRepairShopDTO);
		return mv;
	}

	@PostMapping
	public ModelAndView save(@Validated AutoRepairShopDTO dto, Errors errors, RedirectAttributes redirectAttributes)
			throws ParseException {

		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("auto-repair-shop/form");
			mv.addObject("dto", dto);
			mv.addObject("errors", errors.getAllErrors());
			return mv;
		}
		
		//Envia imagem e recupera URL
		if (!dto.getFile().isEmpty()) {
			ImageDTO image = ImageController.upload(dto.getFile());
			dto.setImage(image.getUrl());
		}
		
		AutoRepairShop auto = autoRepairShopMapper.toEntity(dto);
		autoRepairShopService.save(auto);
		redirectAttributes.addFlashAttribute("message", "Oficina salva com sucesso!");

		return new ModelAndView("redirect:oficinas");
	}

	@PutMapping
	public ModelAndView update(@Validated AutoRepairShopDTO dto, Errors errors, RedirectAttributes redirectAttributes)
			throws ParseException {

		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("auto-repair-shop/edit");
			mv.addObject("dto", dto);
			mv.addObject("errors", errors.getAllErrors());
			return mv;
		}
		
		Optional<AutoRepairShop> optionalAutoRepairShop = autoRepairShopService.findById(dto.getId());
		if (!optionalAutoRepairShop.isPresent()) {
			throw new EntityNotFoundException("A oficina não foi encontrada pelo id informado.");
		}
		
		AutoRepairShop auto = autoRepairShopMapper.toEntity(dto);
		
		autoRepairShopService.save(auto);
		
		redirectAttributes.addFlashAttribute("message", "Oficina Atualizada com sucesso!");
		
		return new ModelAndView("redirect:oficinas");
	}

	@DeleteMapping(value = "/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {

		Optional<AutoRepairShop> o = autoRepairShopService.findById(id);

		if (!o.isPresent()) {
			throw new EntityNotFoundException("Erro ao exluir, A oficina com cod.:"+ id +" não foi encontrada");
		}

		autoRepairShopService.deleteById(id);

		redirectAttributes.addFlashAttribute("message", "Oficina Deletada com sucesso!");

		return new ModelAndView("redirect:oficinas");
	}
}
