package com.brpl.kyc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brpl.kyc.demo.model.KYCUser;

public interface KYCUserRepository extends JpaRepository<KYCUser, Long> {

}
