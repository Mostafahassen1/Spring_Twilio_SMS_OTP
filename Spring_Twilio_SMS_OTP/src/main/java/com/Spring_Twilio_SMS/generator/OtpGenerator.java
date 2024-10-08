package com.Spring_Twilio_SMS.generator;

import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;
@Configuration
public class OtpGenerator {
     private  String otp ;
    public  String message ;

    public String getGenerateOtp() {
        otp = generateOtp(6);
        message = otp;
        return message;
    }
    public String getOtp(){
        return otp;
    }


    private String generateOtp(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append(random.nextInt(10));  // Append a random digit (0-9)
        }
        return otp.toString();
    }
}
