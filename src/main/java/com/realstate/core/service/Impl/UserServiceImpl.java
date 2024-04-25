package com.realstate.core.service.Impl;

import com.realstate.core.entity.Users;
import com.realstate.core.exception.NotFoundException;
import com.realstate.core.repository.UserRepository;
import com.realstate.core.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the UserService interface providing methods to retrieve user information.
 * This class implements the UserService interface and provides methods to interact with the
 * user data stored in the database. It primarily focuses on retrieving user information
 * based on the user's email address.
 * Author: [Aashish Karki]
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    /**
     * Constructs a new UserServiceImpl instance with the specified UserRepository.
     *
     * @param userRepository The repository for accessing user data.
     */
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves a user from the database by their email address.
     * This method queries the database to find a user with the specified email address.
     * If a user with the given email address is found, it is returned as an Optional.
     * If no user is found with the provided email address, an empty Optional is returned.
     * If the user is not found, a NotFoundException is thrown.
     *
     * @param email The email address of the user to retrieve.
     * @return An Optional containing the user if found, otherwise an empty Optional.
     * @throws NotFoundException If no user is found with the provided email address.
     */
    @Override
    public Optional<Users> getUserByEmail(String email) throws NotFoundException {
        return Optional.ofNullable(userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User with email was not found")));
    }
}
