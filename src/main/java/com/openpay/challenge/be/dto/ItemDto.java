package com.openpay.challenge.be.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Represents an item in Marvel character's comics or events.")
public class ItemDto {

    @Schema(description = "The resource URI of the item.")
    public String resourceUri;

    @Schema(description = "The name of the item.")
    public String name;

    @Schema(description = "The type of the item.")
    public String type;
}