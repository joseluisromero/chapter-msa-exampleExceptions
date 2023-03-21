package com.pichincha.encrypt.rsa.service.mapper;

import com.pichincha.encrypt.rsa.service.dto.PersonDto;
import com.pichincha.encrypt.rsa.domain.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person personDtoToPerson(PersonDto personDto);

    PersonDto personToPersonDto(Person person);
}
