package com.pichincha.encrypt.rsa.repository;

import com.pichincha.encrypt.rsa.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
