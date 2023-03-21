package com.pichincha.encrypt.rsa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.empaquetado.service.TestService;
import com.pichincha.empaquetado.service.impl.TestServiceImpl;
import com.pichincha.encrypt.rsa.service.ExceptionService;
import com.pichincha.encrypt.rsa.service.dto.RequestDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest
@Slf4j
@ContextConfiguration(classes = {TestController.class, TestServiceImpl.class})
public class TestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    TestService testService;

    @MockBean
    private ExceptionService exceptionService;


    @BeforeEach()
    void setUp() {
    }

    @Test
    void shouldGenInformationClientWhenHashOpportunityExist() throws Exception {

        when(exceptionService.divide(any())).thenReturn(Double.parseDouble("5"));

        mockMvc.perform(post(  "/exceptions/divide")
                        .content(mapper.writeValueAsString(RequestDto.builder().num1(5).num2(10).build()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void shouldReturnOKWhenExecuteReference() throws Exception {

      // when(testService.saludar(anyString())).thenReturn("prueba");
        mockMvc.perform(get(  "/exceptions/referencia/prueba")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }




}
