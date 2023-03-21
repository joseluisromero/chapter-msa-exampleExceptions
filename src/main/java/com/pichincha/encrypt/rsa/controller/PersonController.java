package com.pichincha.encrypt.rsa.controller;

import com.pichincha.encrypt.rsa.service.dto.PersonDto;
import com.pichincha.encrypt.rsa.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @PostMapping("calculeBeforeSave")
    public ResponseEntity<PersonDto> calculeBeforeSave(@RequestBody @Valid PersonDto personDto) {
        return new ResponseEntity<>(personService.operationBeforeSave(personDto), HttpStatus.CREATED);
    }
}
