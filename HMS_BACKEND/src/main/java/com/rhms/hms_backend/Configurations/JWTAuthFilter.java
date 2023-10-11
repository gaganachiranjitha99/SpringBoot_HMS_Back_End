package com.rhms.hms_backend.Configurations;

import com.rhms.hms_backend.Services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader=request.getHeader("Authorization");
        final String jwt;
        final String userIndex;
        if (authHeader==null || !authHeader.startsWith("Bearer ")){ //Token Should be always starts with Bearer
            filterChain.doFilter(request,response);
            return;
        }
        jwt=authHeader.substring(7);//Extracting JWT Token
        userIndex=jwtService.extractUsername(jwt);//Extracting UserIndex Using JwtService class's extractUsername method
        if(userIndex !=null && SecurityContextHolder.getContext().getAuthentication()==null){ //Checking whether the userIndex is null and the User already Authenticated
            UserDetails userDetails=this.userDetailsService.loadUserByUsername(userIndex);
            if(jwtService.isTokenValid(jwt,userDetails)){ //Checking whether the User and Token is Valid.
                UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken( //Creating a object of UsernamePasswordAuthenticationToken and pass below values
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response); //Passing hand to next filter tobe executed

    }


}
