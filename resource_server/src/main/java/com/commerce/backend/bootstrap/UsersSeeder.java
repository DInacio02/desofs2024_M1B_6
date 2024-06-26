package com.commerce.backend.bootstrap;

import com.commerce.backend.dao.RoleRepository;
import com.commerce.backend.dao.UserRepository;
import com.commerce.backend.model.entity.Role;
import com.commerce.backend.model.entity.RoleEnum;
import com.commerce.backend.model.entity.User;
import com.commerce.backend.model.request.user.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Profile("seed")
public class UsersSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsersSeeder(
            RoleRepository roleRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        this.createAdministrator();
        this.createManager();
        this.createUser();
    }

    private void createAdministrator() {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.ADMIN);

        if (optionalRole.isEmpty()) {
            return;
        }

        createUserWithRole("admin@email.com", "123456", optionalRole.get());
    }

    private void createManager() {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.MANAGER);

        if (optionalRole.isEmpty()) {
            return;
        }

        createUserWithRole("manager@email.com", "123456", optionalRole.get());
    }

    private void createUser() {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);

        if (optionalRole.isEmpty()) {
            return;
        }

        createUserWithRole("user1@email.com", "123456", optionalRole.get());
    }

    private void createUserWithRole(String email, String password, Role role) {
        RegisterUserRequest userDto = new RegisterUserRequest();
        userDto.setEmail(email);
        userDto.setPassword(password);

        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent()) {
            return;
        }

        User user = new User();

        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmailVerified(1);
        user.setRole(role);

        userRepository.save(user);
    }
}
