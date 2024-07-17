package com.Spring_Twilio_SMS.sender;

import com.Spring_Twilio_SMS.request_data.SmsRequest;
import com.Spring_Twilio_SMS.config.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements TwilioSenderSms {
  private  final TwilioConfiguration twilioConfiguration ;

  @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void SendSms(SmsRequest smsRequest) {
      if(isPhoneNumberValid(smsRequest.getPhoneNumber())){
          PhoneNumber to =new PhoneNumber(smsRequest.getPhoneNumber()) ;
          PhoneNumber from = new PhoneNumber(twilioConfiguration.getPhoneNumber() ) ;
          String message = smsRequest.getMessage();
          MessageCreator creator =Message.creator(to , from , message) ;
          creator.create();

      }
      else{
          throw new IllegalArgumentException(
                  "Phone Number [ " +smsRequest.getPhoneNumber() +" ] is not a valid number") ;
      }

    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        // implement here , to check the number is valued or not based on the rules of country EGY -> +20
      return true ;
    }
}
