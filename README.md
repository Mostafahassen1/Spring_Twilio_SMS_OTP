# Spring_Twilio_SMS_OTP

## Introduction
This project demonstrates how to use Spring Boot to send SMS messages and generate OTPs (One-Time Passwords) using Twilio. It includes integration with Redis to store OTPs after they are generated, utilizes Docker Compose for containerized deployments, and provides functionality to validate OTPs when users submit them for verification.


## Technologies Used

- **Java 17:** The programming language used for developing the application.
- **Spring Boot 3.3.1:** The framework used to build and run the application.
- **Twilio SDK 7.34.0:** The Twilio SDK for sending SMS messages.
- **Spring Data Redis:** Used for integrating Redis into the Spring application for OTP storage.
- **Docker Compose:** Used for containerizing the application and managing multiple containers.
- **Maven:** The build automation tool used for managing project dependencies and building the application.


## Prerequisites
- JDK 17 or higher
- Maven
- Docker and Docker Compose
- Active Twilio account with a valid email address

## Before Running the Project

Before running your project, ensure you have completed the following steps:

1. **Implement Email in Twilio:**
   - Ensure your Twilio account is configured with a valid email address for sending SMS messages and OTP Number .

2. **Implement Docker Compose:**
   - Set up Docker Compose for containerized deployment of your application and Redis.

### Handling Environment Variables for Sensitive Information

Before running your application, handle sensitive information using environment variables. Follow these steps:

#### Create a `.env` File:

1. **Create a .env File:**
   - Create a file named `.env` in the root directory of your project.
   - Add your sensitive information to this file in the format `KEY=VALUE`.

   **Example `.env` file:**
   ```plaintext
   TWILIO_ACCOUNT_SID=your_twilio_account_sid
   TWILIO_AUTH_TOKEN=your_twilio_auth_token
   TWILIO_PHONE_NUMBER=your_twilio_phone_number
   REDIS_PASSWORD=your_redis_password


## After Running the Project

### Endpoints

### 1. Send SMS

- **Endpoint:** `POST  localhost:8080/api/api/v1/sms`
- **Description:** Endpoint to send a SMS message to a specific phone number.
- **Request Body:**
  ```json
  {
      "PhoneNumber": "+201006332994",
      "Message": "the massage From Mostafa "
  }

``
![image](https://github.com/user-attachments/assets/a7922cd1-5d85-4e8b-88cc-c3c01966445c)

![image](https://github.com/user-attachments/assets/d166a4bc-ebf5-4ea8-9cdf-f9d0c6ed44bd)


  ### 2. Generate OTP

- **Endpoint:** `POST localhost:8080/api/v1/otp`
- **Description:** Endpoint to generate OTP and send it via SMS to a specified phone number.
- **Request Body:**
  ```json
  {
      "PhoneNumber": "+201006332994"
  }

``
  ![image](https://github.com/user-attachments/assets/86f8abd2-386b-415f-aff7-d54d384c7edd)


### 3. Verify OTP

- **Endpoint:** `POST localhost:8080/api/v1/otp/verify `
- **Description:** Endpoint to verify the OTP entered ( OtpNumber ) by the user for a specific phone number.
- **Request Body:**
  ```json
  {
      "PhoneNumber": "+201006332994",
      "OtpNumber": "123456"
  }

  ```
  ![image](https://github.com/user-attachments/assets/13652bbc-a987-4302-b444-30b09fee436b)

  ![image](https://github.com/user-attachments/assets/71f3fc66-f9b7-4f38-a9a0-7ff30f6f61ea)


  Note: The OTP number is valid for 6 minutes only. This time can be changed from the code.

```java
// Example line in TwilioOtpSender class
private static final int TIME_TO_LIVE = 6; // in minutes

```

  


  

