package com.samsung.smartretail.mcd.filter.preparation;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Preparationfilter extends OncePerRequestFilter{

	/*
	 * Cross Domain 문제를 해결해주기 위하여 preparation/createTodolist 부분에 필터를 적용하였습니다.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
					throws ServletException, IOException {
		// TODO Auto-generated method stub

		String origin = request.getHeader("Origin");

		response.addHeader("Access-Control-Allow-Origin", "*");

		if("OPTIONS".equals(request.getMethod())){

			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE");
			response.addHeader("Access-Control-Allow-Credentials", "true");
			response.addHeader("Access-Control-Max-Age", "1800");
			response.addHeader("Access-Control-Allow-Headers",
		    request.getHeader("Access-Control-Request-Headers"));
			
		}
		
		filterChain.doFilter(request, response);
	}


}
