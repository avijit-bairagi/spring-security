package com.ovi.app.entity;

import com.ovi.app.model.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Role name;

    public RoleEntity() {
    }

    public RoleEntity(Role name) {
        this.name = name;
    }
}