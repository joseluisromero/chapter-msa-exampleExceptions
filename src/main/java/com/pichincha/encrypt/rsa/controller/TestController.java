package com.pichincha.encrypt.rsa.controller;

import com.pichincha.empaquetado.service.TestService;
import com.pichincha.encrypt.rsa.service.ExceptionService;
import com.pichincha.encrypt.rsa.service.dto.RequestDto;
import com.pichincha.generic.encrypt.exception.CryptoException;
import com.pichincha.generic.encrypt.service.CryptoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/exceptions")
@CrossOrigin
public class TestController {
    private final ExceptionService exceptionService;

    //private final CryptoService cryptoService;
    private final TestService testService;

    private final CryptoService cryptoService;

    @PostMapping("/divide")
    public ResponseEntity<Double> divide(@RequestBody RequestDto requestDto) {
        return new ResponseEntity<>(exceptionService.divide(requestDto), HttpStatus.OK);
    }

    @GetMapping("/referencia/{dato}")
    public ResponseEntity<String> referencia(@PathVariable("dato") String dato){
        return new ResponseEntity<>(testService.saludar(dato), HttpStatus.OK);
       // return new ResponseEntity<>("saludo", HttpStatus.OK);
    }

    @GetMapping("/referencia2/{dato}")
    public ResponseEntity<String> referencia2(@PathVariable("dato") String dato) throws CryptoException {
        return new ResponseEntity<>(cryptoService.encrypt(dato), HttpStatus.OK);
        // return new ResponseEntity<>("saludo", HttpStatus.OK);
    }
    @PostMapping("/referencia2")
    public ResponseEntity<String> getDescript(@RequestBody String dato) throws CryptoException {
        dato=dato.replace("{\r\n    \"","");
        dato=dato.replace("\"\r\n}","");
        ///String mm="oUNaCy9YyGNIp6QqUMlAUiZc1AaJbSGn+1YcNVDO17DCzsBKVKAIznSy/X9k2LG6iTTUjW5sC8TyWKR1y9Jbg29XA+8uHNVog9hC3M8/nJw69JQuQCV5mEZx4OjANtDutjcM8Up2l+ZKBcIF6F4G1ux/+T46IWeqVsExuGhKqjGoE6D46y9ILc/rTCI9E1Y8uU008tQINAph7ZJ3Ye79KbXPeGiZYvNbVzuwgj/dwh6B6MpjWS9CgaueJSSNsEspcbxOfrhI0UDFAnOB4spB0Z/HaONvd7umxnA3Ac+mnOoZAO+0KboA0wdmsRME4VCQ4xS9N3b+m58DFao3MBtgjg==";
        return new ResponseEntity<>(cryptoService.decrypt(dato), HttpStatus.OK);
    }
}
