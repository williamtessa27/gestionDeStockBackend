package com.tessa.gestiondestock.model.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
public class ExtendedUser extends User {

    @Getter
    @Setter
    private Integer idEntreprise;

    public ExtendedUser(String userName, String password,
                        Collection<? extends GrantedAuthority> authorities){
        super(userName, password, authorities);
    }

    public ExtendedUser(String userName, String password, Integer idEntreprise,
                        Collection<? extends GrantedAuthority> authorities){
        super(userName, password, authorities);
        this.idEntreprise = idEntreprise;
    }

}
