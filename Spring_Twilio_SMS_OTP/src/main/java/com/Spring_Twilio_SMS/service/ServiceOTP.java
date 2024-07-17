package com.Spring_Twilio_SMS.service;

import com.Spring_Twilio_SMS.request_data.OTPRequest;
import com.Spring_Twilio_SMS.request_data.VerifyOtpRequest;
import com.Spring_Twilio_SMS.sender.TwilerOtpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServiceOTP {

    private final TwilerOtpSender twilerSenderOTP ;

    @Autowired
    public ServiceOTP(@Qualifier("twilio_otp") TwilerOtpSender twilerSenderOTP) {
        this.twilerSenderOTP = twilerSenderOTP;
    }

    public void sendOTP( OTPRequest otpRequest){
        twilerSenderOTP.SendOtp(otpRequest);

    }

    public void CheckOtp(VerifyOtpRequest verifyOtpRequest) {

        boolean result = twilerSenderOTP.isOTPValid(verifyOtpRequest);
        if (!result) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "This number OTP is not valid");
        } else {
            throw new ResponseStatusException(HttpStatus.OK, "The number OTP is valid");
        }
    }
}
