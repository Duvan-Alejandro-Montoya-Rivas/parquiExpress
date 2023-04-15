package com.calidadSoftware.Parquiexpress.Security.Repository;

import com.calidadSoftware.Parquiexpress.Security.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Integer> {
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<Usuario> findByUsernameOrEmail( String username, String email);
}
