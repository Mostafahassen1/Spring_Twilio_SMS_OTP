package com.Spring_Twilio_SMS.service;

import com.Spring_Twilio_SMS.request_data.OTPRequest;
import com.Spring_Twilio_SMS.sender.TwilerOtpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
}
