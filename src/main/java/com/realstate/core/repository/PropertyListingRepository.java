package com.realstate.core.repository;

import com.realstate.core.entity.PropertyListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PropertyListingRepository extends JpaRepository<PropertyListing, UUID> {
}
