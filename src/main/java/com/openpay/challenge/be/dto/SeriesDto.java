package com.openpay.challenge.be.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "Represents the series of a Marvel character.")
public class SeriesDto {

    @Schema(description = "The quantity of available series.")
    public String available;

    @Schema(description = "The quantity of returned series.")
    public String returned;

    @Schema(description = "The collection URI of the series.")
    public String collectionUri;

    @Schema(description = "The list of series items.")
    public List<ItemDto> items;
}