package com.Spring_Twilio_SMS.sender;

import com.Spring_Twilio_SMS.request_data.OTPRequest;

public interface TwilioSenderOtp {

    void SendOtp(OTPRequest otpRequest) ;
}
