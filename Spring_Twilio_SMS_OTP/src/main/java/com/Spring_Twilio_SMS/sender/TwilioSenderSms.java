package com.Spring_Twilio_SMS.sender;

import com.Spring_Twilio_SMS.request_data.SmsRequest;

public interface TwilioSenderSms {
    void SendSms(SmsRequest smsRequest) ;
}


