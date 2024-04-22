package com.realstate.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Represents a mapping between users and their roles.
 * This class defines the attributes and associations of a user role mapping, including its unique identifier, associated user,
 * and associated role.
 * Database table name: user_role_mapping
 * Author: [Aashish Karki]
 */
@Table(name = "user_role_mapping")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleMapping {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "userId", nullable = false)
  private Users user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "roleId", nullable = false)
  private Role role;
}