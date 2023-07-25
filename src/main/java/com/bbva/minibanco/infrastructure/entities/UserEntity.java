package com.bbva.minibanco.infrastructure.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Users")
public class UserEntity {

    @Id
    @Column(length = 20)
    private String username;
    private String password;
    private String role;
}
