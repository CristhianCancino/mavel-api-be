package com.openpay.challenge.be.service;

import com.openpay.challenge.be.repository.ServiceUsageRepository;
import com.openpay.challenge.be.repository.domain.ServiceUsage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceConsumptionService {

  private final ServiceUsageRepository serviceUsageRepository;


  public ServiceConsumptionService(ServiceUsageRepository serviceUsageRepository) {
    this.serviceUsageRepository = serviceUsageRepository;
  }

  public List<ServiceUsage> getLogs() {
    return serviceUsageRepository.findAll();
  }

}
