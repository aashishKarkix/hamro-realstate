package com.realstate.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Represents a type of real estate property. This class defines the attributes of a
 * property type, including its unique identifier, name, and description. Database table
 * name: property_types
 * Author: [Aashish Karki]
 */
@Table(name = "property_types")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyType {

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "name", unique = true, nullable = false)
  private String name;

  @Column(name = "description")
  private String description;
}