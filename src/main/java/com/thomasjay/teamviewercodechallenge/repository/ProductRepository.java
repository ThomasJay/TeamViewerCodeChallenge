package com.thomasjay.teamviewercodechallenge.repository;

import com.thomasjay.teamviewercodechallenge.db.model.ProductDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<ProductDB, String> {
}
