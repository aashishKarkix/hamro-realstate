package com.realstate.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

/**
 * Represents a listing for a real estate property. This class defines the attributes and
 * associations of a property listing, including its unique identifier, associated
 * property, status, price, listed date, and transaction type.
 * Database table name: property_listings
 * Author: [Aashish Karki]
 */
@Table(name = "property_listings")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyListing {

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "propertyId", nullable = false)
  private Property property;

  @Column(name = "status", nullable = false)
  private String status;

  @Column(name = "price", nullable = false)
  private Double price;

  @Temporal(TemporalType.DATE)
  @Column(name = "listedDate")
  private Date listedDate;

  @Column(name = "transactionType", nullable = false)
  private String transactionType;
}
