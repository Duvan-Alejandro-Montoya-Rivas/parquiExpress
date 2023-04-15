package com.calidadSoftware.Parquiexpress.Security.Entity;

import com.calidadSoftware.Parquiexpress.Security.Enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Usuario")
public class Usuario  {
    @Id
    @Column(unique = true, nullable = false)
    private int id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String cellphone;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    private String userid;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private List<Roles> roles ;

}
