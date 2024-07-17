package com.Spring_Twilio_SMS.sender;

import com.Spring_Twilio_SMS.request_data.VerifyOtpRequest;

public interface TwilioSenderVerifyOtp {

    boolean isOTPValid(VerifyOtpRequest verifyOtpRequest) ;

    void addOTP(String phoneNumber, String otpCode) ;

}
