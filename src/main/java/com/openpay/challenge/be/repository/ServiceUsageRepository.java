package com.openpay.challenge.be.repository;

import com.openpay.challenge.be.repository.domain.ServiceUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceUsageRepository extends JpaRepository<ServiceUsage, Long> {
}