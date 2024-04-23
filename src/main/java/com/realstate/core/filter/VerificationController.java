package com.realstate.core.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling user email verification requests.
 * <p>
 * This controller class provides an endpoint for verifying the validity of a user's email
 * verification token. It delegates the token verification process to the
 * {@link UserEmailVerificationService}.
 * Author: [Aashish Karki]
 */
@RestController
public class VerificationController {

    private final UserEmailVerificationService verificationService;

    /**
     * Constructs a new VerificationController instance with the specified
     * UserEmailVerificationService.
     *
     * @param verificationService The service responsible for user email verification.
     */
    @Autowired
    public VerificationController(UserEmailVerificationService verificationService) {
        this.verificationService = verificationService;
    }

    /**
     * Verifies the validity of the provided user email verification token.
     * This method handles GET requests to the "/verify" endpoint and verifies the validity
     * of the provided user email verification token. It extracts the token from the request
     * URLs query parameters and delegates the token verification process to the
     * UserEmailVerificationService. The method returns true if the token is valid for user
     * email verification, otherwise false.
     *
     * @param token The user email verification token to be verified.
     * @return true if the token is valid for user email verification, false otherwise.
     */
    @GetMapping("/verify")
    public boolean verifyToken(@RequestParam("token") String token) {
        return verificationService.verifyToken(token);
    }
}