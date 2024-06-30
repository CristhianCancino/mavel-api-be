package com.openpay.challenge.be.controller;

import com.openpay.challenge.be.dto.CharacterDto;
import com.openpay.challenge.be.repository.domain.ServiceUsage;
import com.openpay.challenge.be.service.CharacterService;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/characters")
@Tag(name = "Character Controller", description = "Operations pertaining to characters in Marvel API")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    @Operation(summary = "View a list of available characters",
            description = "Get all characters from Marvel API",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                            content = {@io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CharacterDto.class))}),
                    @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
                    @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
                    @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
            })
    public List<CharacterDto> getCharacters() {
        log.info("Getting characters from Marvel API");
        return characterService.getCharacters();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a character by its ID",
            description = "Get a specific character from Marvel API by its ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved character",
                            content = {@io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CharacterDto.class))}),
                    @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
                    @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
                    @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
            })
    public CharacterDto getCharacterById(@ApiParam(value = "ID value for the character you want to retrieve", required = true) @PathVariable("id") int characterId) {
        log.info("Getting character with id {} from Marvel API", characterId);
        return characterService.getCharacterById(characterId);
    }

    @GetMapping("/logs")
    @Operation(hidden = true,
            summary = "Get service logs",
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
        return characterService.getLogs();
    }
}