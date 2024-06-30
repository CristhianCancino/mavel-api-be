package com.openpay.challenge.be.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ComicsDto {

    @Schema(description = "The quantity of available comics.")
    public String available;

    @Schema(description = "The quantity comics of returned.")
    public String returned;

    @Schema(description = "The collection URI of the comics.")
    public String collectionUri;

    @Schema(description = "The list of comic items.")
    public List<ItemDto> items;

}
