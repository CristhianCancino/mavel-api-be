package com.openpay.challenge.be.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "Represents the events of a Marvel character.")
public class EventsDto {

    @Schema(description = "The quantity of available events.")
    public String available;

    @Schema(description = "The quantity of returned events.")
    public String returned;

    @Schema(description = "The collection URI of the events.")
    public String collectionUri;

    @Schema(description = "The list of event items.")
    public List<ItemDto> items;
}