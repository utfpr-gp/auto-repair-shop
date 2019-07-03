package br.edu.utfpr.autorepairshop.exception;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {
	private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


	/**
	 *
	 * Tratador genérico de exceptions.
	 * Trata de qualquer exceptions, caso não haja tratador mais específico.
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

		log.error("[URL] : {}", req.getRequestURL(), e);

		//caso contrário, envia para a visão de erro
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", e.getMessage());
		mv.addObject("url", req.getRequestURL());
		mv.setViewName("error/error-handler");
		return mv;
	}

	/**
	 *
	 * Tratador de erro mais específico.
	 * Entidade não encontrada pelo id.
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = EntityNotFoundException.class)
	public String entityNotFound(HttpServletRequest req, Exception e) throws Exception {

		log.error("[URL] : {}", req.getRequestURL(), e);
		return "error/not-found";
	}

	/**
	 *
	 * Trata do código de status 405.
	 *
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ModelAndView handleError405(HttpServletRequest request, Exception e) {
		ModelAndView mav = new ModelAndView("error/error-405");
		mav.addObject("exception", e);
		return mav;
	}

	/**
	 *
	 * Quando o Spring não encontra um tratador de exception, ele envia 404.
	 * Antes de enviar, ele gera o NoHandlerFoundException.
	 * Isso somente se spring.mvc.throw-exception-if-no-handler-found=true
	 *
	 * Porém, como já há um arquivo com o nome igual ao código de erro na pasta /error, 404.jsp, este arquivo será apresentado.
	 * Portanto, este tratamento somente será executado caso o arquivo 404.jsp seja renomeado ou removido.
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = {NoHandlerFoundException.class})
	@ResponseStatus(value= HttpStatus.NOT_FOUND)
	public ModelAndView handleError4xx(HttpServletRequest request, Exception e) {
		ModelAndView mav = new ModelAndView("error/4xx");
		mav.addObject("message", e.getMessage());
		mav.addObject("url", request.getRequestURL());
		return mav;
	}

	/**
	 *
	 * Trata de erros gerados pelo banco de dados.
	 * Note que @ExceptionHandler recebe duas classes como argumentos.
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = {DataIntegrityViolationException.class, ConstraintViolationException.class})
	public String handleDatabaseException(HttpServletRequest req, Exception e) {
		return "error/error-database";
	}
}
