package com.pichincha.encrypt.rsa.service.impl;

import com.pichincha.encrypt.rsa.domain.Person;
import com.pichincha.encrypt.rsa.repository.PersonRepository;
import com.pichincha.encrypt.rsa.service.dto.PersonDto;
import com.pichincha.encrypt.rsa.service.mapper.PersonMapper;
import com.pichincha.encrypt.rsa.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonDto operationBeforeSave(PersonDto personDto) {
        personDto.setAge(validAge(personDto.getBirtDate()));
        Person person = personRepository.save(personMapper.personDtoToPerson(personDto));
        return personMapper.personToPersonDto(person);
    }

    private static Integer validAge(Date dateOfBirth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Period age = Period.between(LocalDate.of(year, month, day), LocalDate.now());
        return age.getYears();
    }
}
