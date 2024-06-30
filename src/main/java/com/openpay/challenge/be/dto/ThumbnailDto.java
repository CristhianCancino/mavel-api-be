package com.openpay.challenge.be.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "Represents the thumbnail of a Marvel character.")
public class ThumbnailDto {

    @Schema(description = "The path of the thumbnail.")
    public String path;

    @Schema(description = "The extension of the thumbnail.")
    public String extension;
}