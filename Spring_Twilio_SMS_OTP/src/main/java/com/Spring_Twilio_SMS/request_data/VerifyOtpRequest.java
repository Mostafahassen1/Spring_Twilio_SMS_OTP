package com.Spring_Twilio_SMS.request_data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.twilio.type.PhoneNumber;

public class VerifyOtpRequest {

    private  final String PhoneNumber ;
    private  final  String  OtpNumber   ;

    public VerifyOtpRequest( @JsonProperty ("PhoneNumber") String phoneNumber,
                             @JsonProperty("OtpNumber") String otpNumber) {
        PhoneNumber = phoneNumber;
        OtpNumber = otpNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getOtpNumber() {
        return OtpNumber;
    }

    @Override
    public String toString() {
        return "VerifyOtpRequest{" +
                "PhoneNumber='" + PhoneNumber + '\'' +
                ", OtpNumber='" + OtpNumber + '\'' +
                '}';
    }
}
