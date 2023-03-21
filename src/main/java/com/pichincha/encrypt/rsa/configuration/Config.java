package com.pichincha.encrypt.rsa.configuration;

import com.pichincha.empaquetado.service.TestService;
import com.pichincha.empaquetado.service.impl.TestServiceImpl;
import com.pichincha.generic.encrypt.repository.CryptoRepository;
import com.pichincha.generic.encrypt.repository.impl.CryptoRepositoryImpl;
import com.pichincha.generic.encrypt.service.CryptoService;
import com.pichincha.generic.encrypt.service.impl.CryptoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public TestService testService() {
        return new TestServiceImpl();

    }
    @Bean
    public CryptoService cryptoService() {
        return new CryptoServiceImpl();

    }
    @Bean
    public CryptoRepository cryptoRepository(){
        return new CryptoRepositoryImpl();
    }
}
