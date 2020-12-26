package com.ceiba.infraestructura.seguridad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ceiba.infraestructura.seguridad.util.ConstantesSeguridad;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        setFilterProcessesUrl(ConstantesSeguridad.ENDPOINT_LOGIN); 
    }

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
		String authorizationCredentials = req.getHeader(ConstantesSeguridad.HEADER_STRING).split(" ")[1];
		String decodeCredentials = new String(Base64.getDecoder().decode(authorizationCredentials));
		return authenticationManager
				.authenticate(
						new UsernamePasswordAuthenticationToken(
								decodeCredentials.split(":")[0], 
								decodeCredentials.split(":")[1], 
								new ArrayList<>()
						)
				);
	}

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException {
        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + ConstantesSeguridad.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(ConstantesSeguridad.SECRET.getBytes()));

        String body = "{\"accessToken\": \"" + token + "\"}";

        res.getWriter().write(body);
        res.getWriter().flush();
    }
    
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
        response.getWriter().print(authException.getLocalizedMessage());
        response.getWriter().flush();
    }
}
