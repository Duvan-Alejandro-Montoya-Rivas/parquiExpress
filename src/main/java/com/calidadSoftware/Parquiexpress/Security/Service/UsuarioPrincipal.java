package com.calidadSoftware.Parquiexpress.Security.Service;

import com.calidadSoftware.Parquiexpress.Security.Entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;


@AllArgsConstructor
@Getter
@Setter
public class UsuarioPrincipal implements UserDetails {
    private  String username, password, email;
    private Collection<? extends GrantedAuthority> grantedAuthorities;


    public static UsuarioPrincipal build (Usuario usuario){
        Collection<GrantedAuthority> authorities=
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getUsername(), usuario.getPassword(), usuario.getEmail(), authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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

    public String getEmail(){
        return this.email;
    }
}
