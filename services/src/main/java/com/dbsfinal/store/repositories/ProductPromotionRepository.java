package com.dbsfinal.store.repositories;

import com.dbsfinal.store.entity.ProductPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPromotionRepository extends JpaRepository<ProductPromotion, Integer> {

    void deleteByPromotion_promotionId(Integer id);
}
