package com.thomasjay.teamviewercodechallenge.repository;

import com.thomasjay.teamviewercodechallenge.db.model.OrderDB;
import com.thomasjay.teamviewercodechallenge.db.model.OrderItemDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemDB, String> {

    @Query("SELECT oi FROM OrderItemDB oi WHERE oi.orderId = :orderId")
    public List<OrderItemDB> findAllByOrderId(String orderId);
}
