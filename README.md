# Bajaj Finserv Health Qualifier 1 - JAVA

A Spring Boot application developed as part of the Bajaj Finserv hiring challenge.  
This project demonstrates backend development skills in Java and Spring Boot, including HTTP requests, SQL problem-solving, and secure data transmission using JWT tokens.

---

## Table of Contents

- [Project Overview](#project-overview)  
- [Features](#features)  
- [Technologies Used](#technologies-used)  
- [Setup & Installation](#setup--installation)  

---

## Project Overview

This Spring Boot application is designed to solve a specific hiring challenge from Bajaj Finserv.  

**Workflow:**

1. On startup, the application sends a POST request to generate a webhook URL.  
2. It receives a SQL problem as a response from the webhook.  
3. The application processes the SQL problem, computes the solution/query, and stores it.  
4. Finally, it sends the solution back to the webhook URL using a JWT token for secure communication.  

This project demonstrates practical skills in REST API integration, SQL problem-solving, and Spring Boot automation.

---

## Features

- Sends POST request on application startup.  
- Fetches SQL challenge from a remote API.  
- Solves SQL problems dynamically.  
- Sends solution to webhook using JWT authentication.  
- Modular and easily extensible Spring Boot application.

---

## Technologies Used

- Java 17  
- Spring Boot 3.x  
- Spring Web (REST API support)  
- Spring Data JPA (optional, if SQL database integration is used)  
- JWT (JSON Web Token) for secure API communication  
- Maven for dependency management  

---

## Setup & Installation

1. **Clone the repository**
```bash
git clone https://github.com/SanjuktaMu/Bajaj-Finserv-Health--Qualifier-1---JAVA.git
cd Bajaj-Finserv-Health--Qualifier-1---JAVA
