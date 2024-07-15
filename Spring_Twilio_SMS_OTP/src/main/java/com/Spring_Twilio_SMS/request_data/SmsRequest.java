package com.Spring_Twilio_SMS.request_data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsRequest {


    private final String phoneNumber ;  // distinction
    private final String message ;

    public SmsRequest( @JsonProperty("PhoneNumber") String phoneNumber
                     , @JsonProperty("Massage") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
