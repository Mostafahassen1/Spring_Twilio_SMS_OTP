package com.Spring_Twilio_SMS.service;

import com.Spring_Twilio_SMS.exception.ErrorResponse;
import com.Spring_Twilio_SMS.request_data.OTPRequest;
import com.Spring_Twilio_SMS.request_data.VerifyOtpRequest;
import com.Spring_Twilio_SMS.sender.TwilerOtpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServiceOTP {

    private final TwilerOtpSender twilerSenderOTP ;

    @Autowired
    public ServiceOTP(@Qualifier("twilio_otp") TwilerOtpSender twilerSenderOTP) {
        this.twilerSenderOTP = twilerSenderOTP;
    }

    public ResponseEntity<ErrorResponse> sendOTP(OTPRequest otpRequest){

        try {
            twilerSenderOTP.SendOtp(otpRequest);
            return ResponseEntity.ok(new ErrorResponse(HttpStatus.OK.value(), "OTP sent successfully"));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to send OTP");
        }

    }

    public ResponseEntity<ErrorResponse> CheckOtp(VerifyOtpRequest verifyOtpRequest) {

        boolean result = twilerSenderOTP.isOTPValid(verifyOtpRequest);
        if (!result) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This number OTP is not valid");

        } else {
            ErrorResponse successResponse = new ErrorResponse(HttpStatus.OK.value(), "The number OTP is valued .");
            return new ResponseEntity<>(successResponse, HttpStatus.ACCEPTED);
        }
    }
}
