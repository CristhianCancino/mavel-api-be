package com.openpay.challenge.be.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "Represents a URL related to a Marvel character.")
public class UrlDto {

    @Schema(description = "The type of the URL.")
    public String type;

    @Schema(description = "The URL itself.")
    public String url;
}