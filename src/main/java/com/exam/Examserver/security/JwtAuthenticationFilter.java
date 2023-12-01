package com.exam.Examserver.security;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.Examserver.services.Impl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtHelper jwtHelper;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	  @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	            throws ServletException, IOException {

	        final String requestTokenHeader = request.getHeader("Authorization");

	        String username = null;
	        String token = null;

	        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
	            token = requestTokenHeader.substring(7); // Remove "Bearer " prefix
	            try {
	                username = jwtHelper.getUsernameFromToken(token);
	            } catch (IllegalArgumentException e) {
				e.printStackTrace();
				System.out.print("one");
			} catch (ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println("two");
			} catch (MalformedJwtException e) {
				logger.info("Some changed has done in token !! Invalid Token");
				e.printStackTrace();
			} catch (Exception e) {
			
			System.out.println(e+"three");

			}

		}  else {
			System.out.println("header is missing");
		}


	        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	            if (jwtHelper.validateToken(token, userDetails)) {
	                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
	                        userDetails, null, userDetails.getAuthorities());
	                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(authentication);
	            }
	        }

	        filterChain.doFilter(request, response);

	}

}
