package com.openpay.challenge.be.controller;

import com.openpay.challenge.be.repository.domain.ServiceUsage;
import com.openpay.challenge.be.service.ServiceConsumptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/admin")
@Tag(name = "Service Consumption Controller", description = "Operations pertaining to service consumption logs")
@RequiredArgsConstructor
public class ServiceConsumptionController {

  private final ServiceConsumptionService serviceConsumptionService;

  @GetMapping("/logs")
  @Operation(hidden = true,
          summary = "Get service Consumption logs",
          description = "Get logs of the service usage",
          responses = {
                  @ApiResponse(responseCode = "200", description = "Successfully retrieved logs",
                          content = {@io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json",
                                  schema = @Schema(implementation = ServiceUsage.class))}),
                  @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
                  @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
                  @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
          })
  public List<ServiceUsage> getLogs() {
    return serviceConsumptionService.getLogs();
  }
}