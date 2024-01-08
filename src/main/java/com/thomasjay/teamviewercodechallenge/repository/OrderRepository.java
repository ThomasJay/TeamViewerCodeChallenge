package com.thomasjay.teamviewercodechallenge.repository;

import com.thomasjay.teamviewercodechallenge.db.model.OrderDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDB, String> {
}
