package com.realstate.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

/**
 * Represents a user entity.
 * This class defines the attributes of a user, including its unique identifier, first name, last name, email,
 * hashed password, creation date, update date, and deletion date.
 * Database table name: users
 * Author: [Aashish Karki]
 */
@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @Column(name = "hashedPassword")
  private String hashedPassword;

  @Column(name = "createdAt")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @Column(name = "updatedAt")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  @Column(name = "deletedAt")
  @Temporal(TemporalType.TIMESTAMP)
  private Date deletedAt;
}
