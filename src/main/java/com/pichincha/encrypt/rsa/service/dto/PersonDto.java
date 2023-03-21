package com.pichincha.encrypt.rsa.service.dto;

import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDto {
    @NotBlank(message = "El campo ci es obligatorio")
    private String ci;
    private String firstName;
    private String lastName;
    private Date birtDate;
    private int age;
}
