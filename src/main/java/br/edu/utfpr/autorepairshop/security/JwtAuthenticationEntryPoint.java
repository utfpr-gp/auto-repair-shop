package br.edu.utfpr.autorepairshop.security;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	public static final Logger log = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		Map<String, Object> data = new HashMap<>();
		data.put(
				"timestamp",
				Calendar.getInstance().getTime());
		data.put(
				"exception",
				e.getMessage());
		log.info(objectMapper.writeValueAsString(data));
		response.sendRedirect(request.getContextPath() + "/login?auth=0");
	}
}
