package com.petreca.authservice.config;

import com.petreca.authservice.model.Role;
import com.petreca.authservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        // Define a lista de roles que devem existir no sistema
        List<String> essentialRoles = List.of("ROLE_USER", "ROLE_ADMIN"); 

        essentialRoles.forEach(roleName -> {
            if (roleRepository.findByName(roleName).isEmpty()) {
                log.info("Essential role '{}' not found. Creating it...", roleName);
                roleRepository.save(new Role(null, roleName));
                log.info("Role '{}' created successfully.", roleName);
            }
        });
    }
}