package com.Spring_Twilio_SMS.request_data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OTPRequest {

    @JsonProperty("phone_number")
    private final String phoneNumber;  // using camelCase for field name

    public OTPRequest(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
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
