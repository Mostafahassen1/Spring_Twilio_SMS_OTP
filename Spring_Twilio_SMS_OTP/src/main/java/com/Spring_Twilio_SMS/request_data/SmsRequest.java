package com.Spring_Twilio_SMS.request_data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsRequest {

    @JsonProperty("phone_number")
    private final String phoneNumber;
    @JsonProperty("message")
    private final String message;


    public SmsRequest(String phoneNumber, String message) {
        validatePhoneNumber(phoneNumber);
        validateMessage(message);

        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
    }

    private void validateMessage(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
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
                "phone_number='" + phoneNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
