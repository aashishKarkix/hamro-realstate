package com.realstate.core.filter;

import com.realstate.core.dto.UsersDto;
import com.realstate.core.entity.Users;
import com.realstate.core.service.JwtService;
import com.realstate.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class responsible for verifying JWT tokens and user authentication.
 * This service class provides methods to verify the validity of JWT tokens and
 * authenticate users based on the information extracted from the tokens. It utilizes
 * the JwtService to extract and validate token claims and the UserService to fetch
 * user information from the database.
 * Author: [Aashish Karki]
 */
@Service
public class UserEmailVerificationService {

    private final JwtService jwtService;
    private final UserService userService;

    /**
     * Constructs a new VerificationService instance with the specified JwtService
     * and UserService.
     *
     * @param jwtService The service responsible for JWT token handling.
     * @param userService The service responsible for user-related operations.
     */
    @Autowired
    public UserEmailVerificationService(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    /**
     * Verifies the validity of a JWT token for user authentication.
     * This method verifies whether the provided JWT token is valid for authenticating a user.
     * It first extracts the username from the token and attempts to fetch the corresponding user
     * from the database. If the user is found, the token's validity is checked. If the token is
     * valid, a success message is returned; otherwise, a failure message is returned.
     *
     * @param token The JWT token to be verified.
     * @return true if the token is valid for user authentication, false otherwise.
     */
    public boolean verifyToken(String token) {
        Optional<Users> optionalUser = userService.getUserByEmail(jwtService.extractUserName(token));

        if (optionalUser.isPresent()) {
            UsersDto usersDto = UsersDto.fromEntity(optionalUser.get());
            return jwtService.isTokenValid(token, usersDto);
        } else {
            return false;
        }
    }}