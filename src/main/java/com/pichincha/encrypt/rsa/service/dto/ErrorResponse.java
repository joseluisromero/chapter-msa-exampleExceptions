package com.pichincha.encrypt.rsa.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse {
    private int statusCode;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
    private Date timestamp;
    private String message;
    private String description;
}
