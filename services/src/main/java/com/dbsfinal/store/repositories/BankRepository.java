package com.dbsfinal.store.repositories;

import com.dbsfinal.store.entity.Bank;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

    // find all transit banks or search them by searchKey
    @Query("SELECT b " +
            "FROM Bank b inner join BankDetail bd " +
            "where bd.type like %:bankType% " +
            "AND (b.legalName like %:searchKey% " +
            "OR b.code like %:searchKey% " +
            "OR b.prefixCard like %:searchKey%)")
    Page<Bank> findAllIntermediaryBank(@Param("searchKey") String searchKey, @Param("bankType") String bankType , Pageable pageable);

    // find transit bank by id
    @Query("SELECT b FROM Bank b inner join BankDetail bd " +
            "where bd.type like %:bankType% " +
            "AND b.bankId = :bankId")
    Optional<Bank> findIntermediaryBankById(@Param("bankId") int bankId, @Param("bankType") String bankType);

}
