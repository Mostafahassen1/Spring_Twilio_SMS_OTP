package com.Spring_Twilio_SMS.controller;

import com.Spring_Twilio_SMS.exception.ErrorResponse;
import com.Spring_Twilio_SMS.request_data.OTPRequest;
import com.Spring_Twilio_SMS.request_data.VerifyOtpRequest;
import com.Spring_Twilio_SMS.service.ServiceOTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/otp")
public class ControllerOTP {

    private final ServiceOTP serviceOTP ;

    @Autowired
    public ControllerOTP(ServiceOTP serviceOTP) {
        this.serviceOTP = serviceOTP;
    }

    @PostMapping
    public ResponseEntity<ErrorResponse> sendOTP(@RequestBody OTPRequest otpRequest){

        return serviceOTP.sendOTP(otpRequest);
    }

    @PostMapping("/verify")
    public ResponseEntity<ErrorResponse> verifyOTP(@RequestBody VerifyOtpRequest verifyOtpRequest){
    return serviceOTP.CheckOtp(verifyOtpRequest);

    }
}
