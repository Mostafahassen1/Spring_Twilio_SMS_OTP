package com.Spring_Twilio_SMS.request_data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OTPRequest {

    private final String phoneNumber ;  // distinction

    public OTPRequest( @JsonProperty("PhoneNumber") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "OTPRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
