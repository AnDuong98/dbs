package com.dbsfinal.store.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbsfinal.store.entity.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer>  {

	VerificationToken findByToken(String verifyToken);
	
	void deleteByExpiryDateLessThan(Date now);

}
