package com.tessa.gestiondestock.controller;


import com.tessa.gestiondestock.dto.auth.AuthenticationRequest;
import com.tessa.gestiondestock.dto.auth.AuthenticationResponse;
import com.tessa.gestiondestock.services.auth.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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



    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,
                                    ApplicationUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
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

        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken("dummy_access_token").build());
    }
}
