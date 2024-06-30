package com.openpay.challenge.be.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "Represents the stories of a Marvel character.")
public class StoriesDto {

    @Schema(description = "The quantity of available stories.")
    public String available;

    @Schema(description = "The quantity of returned stories.")
    public String returned;

    @Schema(description = "The collection URI of the stories.")
    public String collectionUri;

    @Schema(description = "The list of story items.")
    public List<ItemDto> items;
}