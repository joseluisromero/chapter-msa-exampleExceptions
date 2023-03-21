package com.pichincha.encrypt.rsa.service.impl;

import com.pichincha.encrypt.rsa.service.ExceptionService;
import com.pichincha.encrypt.rsa.service.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExceptionServiceImpl implements ExceptionService {
    @Override
    public double divide(RequestDto requestDto) {
        log.info("request {}", requestDto.toString());
        return requestDto.getNum1() / requestDto.getNum2();
    }
}
