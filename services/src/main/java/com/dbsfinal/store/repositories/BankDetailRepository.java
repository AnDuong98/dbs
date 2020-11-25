package com.dbsfinal.store.repositories;

import com.dbsfinal.store.entity.BankDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BankDetailRepository extends JpaRepository<BankDetail, Integer> {

    @Modifying
    @Query(value = "UPDATE bank_detail b SET b.modified_datetime = now()," +
            " b.status = :status, b.modified_By = :name WHERE id = :id", nativeQuery = true)
    void update(@Param("id") int id, @Param("status") int status, @Param("name") String name);

    Optional<BankDetail> findByBankId(int id);

}
