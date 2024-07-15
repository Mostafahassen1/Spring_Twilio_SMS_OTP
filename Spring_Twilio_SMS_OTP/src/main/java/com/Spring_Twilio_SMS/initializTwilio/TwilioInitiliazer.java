package com.Spring_Twilio_SMS.initializTwilio;

import com.Spring_Twilio_SMS.config.TwilioConfiguration;
import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitiliazer {

    private final TwilioConfiguration twilioConfiguration ;
   private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitiliazer.class);
    @Autowired
    public TwilioInitiliazer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid() ,
                twilioConfiguration.getAuthToken()
        );


    }
}
//The error after deleting the TwilioInitializer class is
//        likely due to the fact that this class  is
//"responsible for initializing the Twilio SDK with configuration details "
//     When you delete this class
//"application loses the configuration necessary for the Twilio SDK "
//        "to function correctly " ,
//        which leads to errors when you   try to use the Twilio API.