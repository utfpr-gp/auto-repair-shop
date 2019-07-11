package br.edu.utfpr.autorepairshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class IndexController {

	public static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@GetMapping
	public ModelAndView showIndex() {
		log.info("Mostrando o index");
		return new ModelAndView("redirect:login");
	}
}