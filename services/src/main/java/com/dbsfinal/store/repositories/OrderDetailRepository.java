package com.dbsfinal.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbsfinal.store.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
