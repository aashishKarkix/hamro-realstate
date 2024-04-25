package com.realstate.core.dto;

import com.realstate.core.entity.Users;
import lombok.*;

import java.util.Date;
import java.util.UUID;

/**
 * Data Transfer Object (DTO) representing a user.
 * This class encapsulates the data of a user for transferring between layers of the application,
 * such as between the service layer and the controller layer.
 * Author: [Aashish Karki]
 * */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UsersDto {
  private UUID id;
  private String firstName;
  private String lastName;
  private String email;
  private String hashedPassword;
  private Date createdAt;
  private Date updatedAt;
  private Date deletedAt;

  /**
   * Convert this {@code UsersDto} instance to a {@code Users} entity.
   *
   * @return {@code Users} entity instance.
   */
  public Users toEntity() {
    Users users = new Users();
    users.setId(this.id);
    users.setFirstName(this.firstName);
    users.setLastName(this.lastName);
    users.setEmail(this.email);
    users.setHashedPassword(this.hashedPassword);
    users.setCreatedAt(this.createdAt);
    users.setUpdatedAt(this.updatedAt);
    users.setDeletedAt(this.deletedAt);
    return users;
  }

  /**
   * Convert a {@code Users} entity to a {@code UsersDto} instance.
   *
   * @param users {@code Users} entity instance.
   * @return {@code UsersDto} instance.
   */
  public static UsersDto fromEntity(Users users) {
    return UsersDto.builder()
        .id(users.getId())
        .firstName(users.getFirstName())
        .lastName(users.getLastName())
        .email(users.getEmail())
        .hashedPassword(users.getHashedPassword())
        .createdAt(users.getCreatedAt())
        .updatedAt(users.getUpdatedAt())
        .deletedAt(users.getDeletedAt())
        .build();
  }

  public static UsersDto getTokenDetails(Users users) {
    return UsersDto.builder().id(users.getId()).firstName(users.getFirstName())
        .lastName(users.getLastName()).email(users.getEmail()).build();
  }
}