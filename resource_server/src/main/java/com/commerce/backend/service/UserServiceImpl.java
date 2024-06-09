package com.commerce.backend.service;

import com.commerce.backend.converter.user.UserResponseConverter;
import com.commerce.backend.dao.RoleRepository;
import com.commerce.backend.dao.UserRepository;
import com.commerce.backend.error.exception.InvalidArgumentException;
import com.commerce.backend.error.exception.ResourceNotFoundException;
import com.commerce.backend.model.entity.Role;
import com.commerce.backend.model.entity.RoleEnum;
import com.commerce.backend.model.entity.User;
import com.commerce.backend.model.request.user.PasswordResetRequest;
import com.commerce.backend.model.request.user.RegisterUserRequest;
import com.commerce.backend.model.request.user.UpdateUserAddressRequest;
import com.commerce.backend.model.request.user.UpdateUserRequest;
import com.commerce.backend.model.response.user.UserResponse;
import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserResponseConverter userResponseConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           UserResponseConverter userResponseConverter) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userResponseConverter = userResponseConverter;
    }

    @Override
    public User register(RegisterUserRequest registerUserRequest) throws Exception {
        if (userExists(registerUserRequest.getEmail())) {
            throw new InvalidArgumentException("An account already exists with this email");
        }

        String userEmail = registerUserRequest.getEmail();
        String userPassword = registerUserRequest.getPassword();

        String sanitizedEmail = Encode.forHtml(userEmail);
        String sanitizedPassword = Encode.forHtml(userPassword);

        if(!sanitizedPassword.equals(userPassword)){
            throw new Exception("Invalid Password: "+userPassword);
        }

        if(!sanitizedEmail.equals(userEmail)){
            throw new Exception("Invalid Email: "+userEmail);
        }

        User user = new User();
        user.setEmail(sanitizedEmail);
        user.setPassword(passwordEncoder.encode(sanitizedPassword));
        user.setEmailVerified(0);

        Optional<Role> role = roleRepository.findByName(RoleEnum.USER);

        if (role.isEmpty()) {
            throw new InvalidArgumentException("User role does not exist");
        }

        user.setRole(role.get());

        return userRepository.save(user);
    }

    @Override
    public UserResponse fetchUser() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (Objects.isNull(userName)) {
            throw new AccessDeniedException("Invalid access");
        }

        Optional<User> user = userRepository.findByEmail(userName);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("User not found");
        }
        return userResponseConverter.apply(user.get());
    }


    @Override
    public User getUser() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (Objects.isNull(userName)) {
            throw new AccessDeniedException("Invalid access");
        }

        Optional<User> user = userRepository.findByEmail(userName);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("User not found");
        }
        return user.get();
    }

    @Override
    public User saveUser(User user) {
        if (Objects.isNull(user)) {
            throw new InvalidArgumentException("Null user");
        }

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        if (Objects.isNull(email)) {
            throw new InvalidArgumentException("Null email");
        }

        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public boolean userExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserResponse updateUser(UpdateUserRequest updateUserRequest) {
        User user = getUser();
        user.setFirstName(updateUserRequest.getFirstName());
        user.setLastName(updateUserRequest.getLastName());
        user.setPhone(updateUserRequest.getPhone());

        user = userRepository.save(user);
        return userResponseConverter.apply(user);
    }

    @Override
    public UserResponse updateUserAddress(UpdateUserAddressRequest updateUserAddressRequest) {
        User user = getUser();
        user.setAddress(updateUserAddressRequest.getAddress());
        user.setCity(updateUserAddressRequest.getCity());
        user.setState(updateUserAddressRequest.getState());
        user.setZip(updateUserAddressRequest.getZip());
        user.setCountry(updateUserAddressRequest.getCountry());

        user = userRepository.save(user);
        return userResponseConverter.apply(user);
    }

    @Override
    public void resetPassword(PasswordResetRequest passwordResetRequest) {
        User user = getUser();
        if (!passwordEncoder.matches(passwordResetRequest.getOldPassword(), user.getPassword())) {
            throw new InvalidArgumentException("Invalid password");
        }

        if (passwordEncoder.matches(passwordResetRequest.getNewPassword(), user.getPassword())) {
            return;
        }

        user.setPassword(passwordEncoder.encode(passwordResetRequest.getNewPassword()));
        userRepository.save(user);
    }

    @Override
    public Boolean getVerificationStatus() {
        User user = getUser();
        return user.getEmailVerified() == 1;
    }


}
