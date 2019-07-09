package br.edu.utfpr.autorepairshop.filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    public static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        log.info("Filtro parte 1");
        CustomHttpServletRequest req = new CustomHttpServletRequest((HttpServletRequest)request);
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("tokenKey")) {
                    log.info("Filtro parte 2");
                    req.putHeader("Authorization", "Bearer " + cookie.getValue());
                }
            }
        }
        chain.doFilter(req, response);
    }
}