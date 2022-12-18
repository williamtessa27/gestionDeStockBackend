package com.tessa.gestiondestock.services.auth;

import com.tessa.gestiondestock.exception.EntityNotFoundException;
import com.tessa.gestiondestock.exception.ErrorCodes;
import com.tessa.gestiondestock.model.Utilisateur;
import com.tessa.gestiondestock.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository repository;

    @Autowired
    public ApplicationUserDetailsService(UtilisateurRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = repository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Aucun utilisateur avec le mail fourni", ErrorCodes.UTILISATEUR_NOT_FOUND)
        );



        return new User(utilisateur.getEmail(), utilisateur.getMotDePasse(), Collections.emptyList());
    }
}
