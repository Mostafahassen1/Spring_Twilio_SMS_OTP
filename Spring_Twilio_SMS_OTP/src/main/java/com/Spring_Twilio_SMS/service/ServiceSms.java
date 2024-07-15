package com.Spring_Twilio_SMS.service;

import com.Spring_Twilio_SMS.request_data.SmsRequest;
import com.Spring_Twilio_SMS.sender.TwilioSenderSms;
import com.Spring_Twilio_SMS.sender.TwilioSmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class ServiceSms {
    private final TwilioSenderSms twilioSmsSender ;

    @Autowired
    public ServiceSms(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
        this.twilioSmsSender = twilioSmsSender;
    }

    public void sendSms(SmsRequest smsRequest){
        twilioSmsSender.SendSms(smsRequest);

    }
}
