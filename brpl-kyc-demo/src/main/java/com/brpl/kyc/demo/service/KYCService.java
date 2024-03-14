package com.brpl.kyc.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brpl.kyc.demo.repository.KYCRequestRepository;

@Service
public class KYCService {

	@Autowired KYCRequestRepository kycRequestRepo;
}
