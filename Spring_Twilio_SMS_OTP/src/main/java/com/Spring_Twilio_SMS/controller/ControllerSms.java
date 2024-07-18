package com.Spring_Twilio_SMS.controller;


import com.Spring_Twilio_SMS.exception.ErrorResponse;
import com.Spring_Twilio_SMS.service.ServiceSms;
import com.Spring_Twilio_SMS.request_data.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sms")
public class ControllerSms {

    private final ServiceSms service;

    @Autowired
    public ControllerSms(ServiceSms service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ErrorResponse> sendSms(@RequestBody SmsRequest smsRequest ){
       return  service.sendSms(smsRequest);
    }
}
