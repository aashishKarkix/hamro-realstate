package com.realstate.core.service;

import com.realstate.core.entity.Users;

import java.util.Optional;

public interface UserService {
    Optional<Users> getUserByEmail(String email);
}
