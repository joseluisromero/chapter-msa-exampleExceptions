package com.pichincha.encrypt.rsa.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class Person {
    @Id
    private String ci;
    private String firstName;
    private String lastName;
    private Date birtDate;
    private int age;
}
