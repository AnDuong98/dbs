package com.dbsfinal.store.repositories;

import com.dbsfinal.store.entity.AppCode;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AppCodeRepository  extends JpaRepository<AppCode, Integer> {
    @Query("SELECT a FROM AppCode a  WHERE a.code LIKE %:searchValue% or a.description LIKE %:searchValue% ")
    List<AppCode> findByCodeOrDescription(@Param("searchValue") String searchValue, Pageable pageable);

}
