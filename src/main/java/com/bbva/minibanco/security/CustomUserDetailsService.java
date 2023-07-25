package com.bbva.minibanco.security;

import com.bbva.minibanco.application.repository.IClientRepository;
import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.infrastructure.entities.UserEntity;
import com.bbva.minibanco.infrastructure.repositories.springdatajpa.IUserSpringRepository;
import com.bbva.minibanco.utilities.ErrorCodes;
import com.bbva.minibanco.utilities.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final IClientRepository clientRepository;
    private final IUserSpringRepository userSpringRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(username.startsWith("int_"))
        {
            Optional<UserEntity> user = userSpringRepository.findById(username);
            if(!user.isPresent())
                throw new UsernameNotFoundException(ErrorCodes.INVALID_LOGIN);
            // Crear un objeto UserDetails con los detalles del usuario
            return User.builder()
                    .username(user.get().getUsername())
                    .password(user.get().getPassword())
                    .roles(Roles.ADMIN)
                    .build();
        }
        else {
            Optional<Client> client = clientRepository.findByPersonalId(username);
            if(!client.isPresent())
                throw new UsernameNotFoundException(ErrorCodes.INVALID_LOGIN);
            if(!client.get().isActive())
                throw new UsernameNotFoundException(ErrorCodes.DISABLED_USER);
            // Crear un objeto UserDetails con los detalles del usuario
            return User.builder()
                    .username(client.get().getPersonalId())
                    .password(client.get().getPassword())
                    .roles(Roles.CLIENT)
                    .build();
        }
    }
}
