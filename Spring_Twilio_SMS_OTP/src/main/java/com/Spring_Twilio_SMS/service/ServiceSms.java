package com.Spring_Twilio_SMS.service;

import com.Spring_Twilio_SMS.exception.ErrorResponse;
import com.Spring_Twilio_SMS.request_data.SmsRequest;
import com.Spring_Twilio_SMS.sender.TwilioSenderSms;
import com.Spring_Twilio_SMS.sender.TwilioSmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

@org.springframework.stereotype.Service
public class ServiceSms {
    private final TwilioSenderSms twilioSmsSender;

    @Autowired
    public ServiceSms(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
        this.twilioSmsSender = twilioSmsSender;
    }

    public ResponseEntity<ErrorResponse> sendSms( SmsRequest smsRequest) {
        try {

            twilioSmsSender.SendSms(smsRequest);

            ErrorResponse successResponse = new ErrorResponse(HttpStatus.OK.value(), "You sent the message successfully.");
            return new ResponseEntity<>(successResponse, HttpStatus.OK);

        } catch (ResponseStatusException ex) {

            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error occurred on the server. Please try again later.");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {

            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                    " Something went wrong.");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

    }
}
