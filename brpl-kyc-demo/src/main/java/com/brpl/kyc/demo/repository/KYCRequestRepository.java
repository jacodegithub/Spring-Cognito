package com.brpl.kyc.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brpl.kyc.demo.model.KYCRequest;
import com.brpl.kyc.demo.model.User;

public interface KYCRequestRepository extends JpaRepository<KYCRequest, Long> {
	List<KYCRequest> findByUser(User user);
}
