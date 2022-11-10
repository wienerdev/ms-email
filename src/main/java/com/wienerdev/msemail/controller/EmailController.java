package com.wienerdev.msemail.controller;

import com.wienerdev.msemail.dto.EmailDTO;
import com.wienerdev.msemail.model.EmailModel;
import com.wienerdev.msemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDTO emailDTO) {
        return new ResponseEntity<>(emailService.sendEmail(emailDTO), HttpStatus.CREATED);
    }
}
