package com.example.projectbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    @NotEmpty(message = "username can not ot be empty")
    private String username;
    @NotEmpty(message = "password can not ot be empty")
    private String password;
    @NotEmpty(message = "role can not ot be empty")
    @Pattern(regexp = "(STUDENT|TEACHER)")
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}



//    private Integer id;
//
//    @Column(unique = true)
//    @NotEmpty(message = "username can not ot be empty")
//    private String userName;
//
//    @NotEmpty(message = "password can not ot be empty")
//    private String password;
//
//
//    @NotEmpty(message = "role can not ot be empty")
//    @Pattern(regexp = "STUDENT|TEACHER")
//    private String role;
