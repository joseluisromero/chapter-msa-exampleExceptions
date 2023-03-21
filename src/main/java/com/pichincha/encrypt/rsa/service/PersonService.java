package com.pichincha.encrypt.rsa.service;

import com.pichincha.encrypt.rsa.service.dto.PersonDto;

public interface PersonService {
    PersonDto operationBeforeSave(PersonDto personDto);
}
