package com.thomasjay.teamviewercodechallenge.db.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orderitems")
@Data
public class OrderItemDB {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String orderId;

    private String productId;

    private Long qtyOrdered;

}
