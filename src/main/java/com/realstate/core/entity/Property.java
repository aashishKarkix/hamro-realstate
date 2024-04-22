package com.realstate.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.UUID;

/**
 * Represents a real estate property. This class defines the attributes and associations
 * of a real estate property, including its unique identifier, owner, type, title,
 * description, area, address, city, state, country, zip code, creation date, update date,
 * and additional attributes. Database table name: properties
 * Author: [Aashish Karki]
 */
@Table(name = "properties")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ownerId", nullable = false)
  private Users owner;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "typeId", nullable = false)
  private PropertyType type;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "area")
  private Double area;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "state", nullable = false)
  private String state;

  @Column(name = "country", nullable = false)
  private String country;

  @Column(name = "zipCode", nullable = false)
  private String zipCode;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "createdAt")
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updatedAt")
  private Date updatedAt;

  @Column(name = "attributes", columnDefinition = "jsonb")
  @JdbcTypeCode(SqlTypes.JSON)
  private String attributes;
}