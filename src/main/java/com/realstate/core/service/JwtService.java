package com.realstate.core.service;

import com.realstate.core.dto.UsersDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

/**
 * Service class responsible for JWT token generation, validation, and extraction of
 * claims. Author: [Aashish Karki]
 */
@Service
@Slf4j
public class JwtService {

  /**
   * Generates a JWT token for the given user with default claims.
   *
   * @param usersDto The user information used to generate the token.
   * @return The generated JWT token.
   */
  public String generateToken(UsersDto usersDto) {
    return generateToken(new HashMap<>(), usersDto);
  }

  /**
   * Generates a JWT token for the given user with custom additional claims.
   *
   * @param extraClaim Additional custom claims to include in the token.
   * @param usersDto   The user information used to generate the token.
   * @return The generated JWT token.
   */
  private String generateToken(Map<String, Objects> extraClaim, UsersDto usersDto) {
    return Jwts
        .builder()
        .setClaims(extraClaim)
        .claim("id", usersDto.getId())
        .claim("firstName", usersDto.getFirstName())
        .claim("lastName", usersDto.getLastName())
        .setSubject(usersDto.getEmail())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 5000))
        .signWith(getSignInKey())
        .compact();
  }

  /**
   * Extracts the username (email) from the given JWT token.
   *
   * @param token The JWT token from which to extract the username.
   * @return The username (email) extracted from the token.
   */
  private String extractUserName(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  /**
   * Extracts the user ID from the given JWT token.
   *
   * @param token The JWT token from which to extract the user ID.
   * @return The user ID extracted from the token.
   */
  private UUID extractUserId(String token) {
    return extractClaim(token, claims -> UUID.fromString((String) claims.get("id")));
  }

  /**
   * Validates whether the given JWT token is valid for the provided user.
   *
   * @param token    The JWT token to validate.
   * @param usersDto The user information to compare with the token claims.
   * @return true if the token is valid for the user, otherwise false.
   */
  public boolean isTokenValid(String token, UsersDto usersDto){
    final String email = extractUserName(token);
    final UUID usersId = (extractUserId(token));
    return (email.equals(usersDto.getEmail())) && (usersId.equals(usersDto.getId()))
        && !isTokenExpired(token);
  }

  /**
   * Checks whether the given JWT token has expired.
   *
   * @param token The JWT token to check for expiration.
   * @return true if the token has expired, otherwise false.
   */
  public boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  /**
   * Extracts the expiration date from the given JWT token.
   *
   * @param token The JWT token from which to extract the expiration date.
   * @return The expiration date extracted from the token.
   */
  private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  /**
   * Extracts a specific claim from the given JWT token using the provided resolver
   * function.
   *
   * @param token         The JWT token from which to extract the claim.
   * @param claimResolver A function to resolve the desired claim from the token's
   *                      claims.
   * @return The extracted claim value.
   */
  private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
    final Claims claims = extractClaim(token);
    return claimResolver.apply(claims);
  }

  /**
   * Extracts all claims from the given JWT token.
   *
   * @param token The JWT token from which to extract all claims.
   * @return The extracted claims from the token.
   */
  private Claims extractClaim(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(getSignInKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  /**
   * Retrieves the signing key used for JWT token generation and validation.
   *
   * @return The signing key.
   */
  private Key getSignInKey() {
    String SECRET_KEY = "XwM0c3Dr5t7wZABg6bKeQLX2c0Aoi+wR8yRiAa/DoIk=";
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
