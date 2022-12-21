package com.tessa.gestiondestock.controller;


import com.tessa.gestiondestock.dto.auth.AuthenticationRequest;
import com.tessa.gestiondestock.dto.auth.AuthenticationResponse;
import com.tessa.gestiondestock.model.auth.ExtendedUser;
import com.tessa.gestiondestock.services.auth.ApplicationUserDetailsService;
import com.tessa.gestiondestock.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tessa.gestiondestock.utils.constants.AUTHENTIFICATION_END_POINT;

@RestController
@RequestMapping(AUTHENTIFICATION_END_POINT)
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final ApplicationUserDetailsService userDetailsService;

    private final JwtUtil jwtUtil;


    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,
                                    ApplicationUserDetailsService userDetailsService,
                                    JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());

        final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);

        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
    }
}
