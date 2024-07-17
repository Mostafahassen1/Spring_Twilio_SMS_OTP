package com.Spring_Twilio_SMS.sender;

import com.Spring_Twilio_SMS.generator.OtpGenerator;
import com.Spring_Twilio_SMS.request_data.OTPRequest;
import com.Spring_Twilio_SMS.config.TwilioConfiguration;
import com.Spring_Twilio_SMS.request_data.VerifyOtpRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service("twilio_otp")
public class TwilerOtpSender implements TwilioSenderOtp, TwilioSenderVerifyOtp {

    private static final String OTP_PREFIX = "otp:";
    private static final int TIME_TO_LIVE = 1; // in minutes

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilerOtpSender.class);
    private final TwilioConfiguration twilioConfiguration;
    private final OtpGenerator otpGenerator;
    private final StringRedisTemplate redisTemplate;

    @Autowired
    public TwilerOtpSender(TwilioConfiguration twilioConfiguration,
                           OtpGenerator otpGenerator, StringRedisTemplate redisTemplate) {
        this.twilioConfiguration = twilioConfiguration;
        this.otpGenerator = otpGenerator;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void SendOtp(OTPRequest otpRequest) {
        PhoneNumber to = new PhoneNumber(otpRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getPhoneNumber());
        String message =  "Your OTP is: " + otpGenerator.getGenerateOtp();
        MessageCreator creator = Message.creator(to, from, message);
        creator.create();
        addOTP(otpRequest.getPhoneNumber(), otpGenerator.getOtp() );

    }

    @Override
    public void addOTP(String phoneNumber, String otpCode) {
        String otpKey = OTP_PREFIX + phoneNumber;

        // Check if the key exists and delete it if it does
        if (redisTemplate.hasKey(otpKey)) {
            redisTemplate.delete(otpKey);
        }

        // Add the new OTP with TTL
        redisTemplate.opsForValue().set(otpKey, otpCode, Duration.ofMinutes(TIME_TO_LIVE));
        //LOGGER.info("OTP {} for phone number {} has been added to Redis.", otpCode, phoneNumber);
    }

    @Override
    public boolean isOTPValid(VerifyOtpRequest verifyOtpRequest) {
        String phoneNumber = verifyOtpRequest.getPhoneNumber();
        String otpCode = verifyOtpRequest.getOtpNumber();

        String otpKey = OTP_PREFIX + phoneNumber;
        String storedOTP = redisTemplate.opsForValue().get(otpKey);
       // LOGGER.info("Redis ---------Key: {}, Value---------: {} the------ Number: {} " ,otpKey , storedOTP , otpCode);
        // Log all data in Redis for debugging
      //  logAllRedisData();

        if (storedOTP != null && storedOTP.equals(otpCode) ){
            redisTemplate.delete(otpKey); // Delete the OTP after successful validation
            return true;
        }

        return false;
    }

//    private void logAllRedisData() {
//        // Fetch all keys with the pattern for OTPs
//        Set<String> keys = redisTemplate.keys(OTP_PREFIX + "*");
//
//        if (keys != null) {
//            for (String key : keys) {
//                String value = redisTemplate.opsForValue().get(key);
//                LOGGER.info("Redis Key: {}, Value: {}", key, value);
//            }
//        } else {
//            LOGGER.info("No keys found in Redis.");
//        }
//    }
}
