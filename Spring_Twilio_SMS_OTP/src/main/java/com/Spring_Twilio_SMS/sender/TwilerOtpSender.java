package com.Spring_Twilio_SMS.sender;


import com.Spring_Twilio_SMS.generator.OtpGenerator;
import com.Spring_Twilio_SMS.request_data.OTPRequest;
import com.Spring_Twilio_SMS.config.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio_otp")
public class TwilerOtpSender implements TwilioSenderOtp {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class) ;
    private  final TwilioConfiguration twilioConfiguration ;
    private  final OtpGenerator  otpGenerator ;
    @Autowired
    public TwilerOtpSender(TwilioConfiguration twilioConfiguration , OtpGenerator  otpGenerator ) {
        this.twilioConfiguration = twilioConfiguration;
        this.otpGenerator = otpGenerator ;
    }

    @Override
    public void SendOtp(OTPRequest otpRequest) {
        PhoneNumber to = new PhoneNumber(otpRequest.getPhoneNumber()) ;
        PhoneNumber from = new PhoneNumber( twilioConfiguration.getPhoneNumber()) ;
        String message = otpGenerator.getMessage();
        MessageCreator creator = Message.creator(to , from , message) ;
        creator.create();
        LOGGER.info("Send OTP {}", otpRequest);
    }
}
