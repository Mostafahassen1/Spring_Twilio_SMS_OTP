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
