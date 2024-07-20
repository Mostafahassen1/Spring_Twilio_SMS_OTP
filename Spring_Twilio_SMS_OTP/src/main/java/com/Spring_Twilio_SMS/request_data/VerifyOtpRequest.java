package com.Spring_Twilio_SMS.request_data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.twilio.type.PhoneNumber;

public class VerifyOtpRequest {

    @JsonProperty ("phone_number")
    private  final String phoneNumber ;
    @JsonProperty("otp_number")
    private  final  String  otpnumber   ;

    public VerifyOtpRequest(  String phoneNumber ,
                              String otpnumber) {

        validatePhoneNumber(phoneNumber);
        validateOtp(otpnumber);

        this.phoneNumber = phoneNumber;
        this.otpnumber = otpnumber;
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
    }
    private void validateOtp(String otpnumber) {
        if (otpnumber == null || otpnumber.trim().isEmpty()) {
            throw new IllegalArgumentException("OTP cannot be null or empty");
        }
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getotpnumber() {
        return otpnumber ;
    }

    @Override
    public String toString() {
        return "VerifyOtpRequest{" +
                "PhoneNumber='" + phoneNumber + '\'' +
                ", OtpNumber='" + otpnumber + '\'' +
                '}';
    }
}
