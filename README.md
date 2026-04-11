# SharkBank Backend

Backend REST API for a digital banking system, built with Spring Boot.

## 1. Overview

SharkBank Backend handles core server-side banking operations including authentication, account management, money transactions, email notifications, and audit APIs.

The codebase is organized by domain modules (auth_users, account, transaction, notification, role, audit_dashboard) and secured with JWT + Spring Security.

## 2. Business Function Groups

### 2.1 Authentication and User Management

- User registration
- Login and JWT token issuance
- Forgot password / reset password with one-time reset code
- View profile and update password
- Upload profile picture to S3

### 2.2 Bank Account Management

- Auto-create an account during user registration
- Retrieve all accounts of the currently authenticated user
- Close account when balance is zero

### 2.3 Transaction Management

- Deposit (DEPOSIT)
- Withdrawal (WITHDRAWAL)
- Transfer (TRANSFER)
- Retrieve transaction history by account with pagination

### 2.4 Notification Management

- Send Thymeleaf template emails for key events:
  - Welcome
  - Account created
  - Credit alert / Debit alert
  - Password reset / password changed
- Persist notification history in database

### 2.5 Authorization and Audit

- Role management (ADMIN)
- Audit APIs for ADMIN/AUDITOR:
  - System totals (users/accounts/transactions)
  - User lookup by email
  - Account and transaction lookups

## 3. Technology Stack

- Java 21
- Spring Boot 4.1.0-M2
- Spring Security + JWT (jjwt)
- Spring Data JPA (Hibernate)
- PostgreSQL
- Thymeleaf (email templates)
- Java Mail Sender (SMTP)
- AWS SDK v2 (S3)
- ModelMapper
- Maven
- Docker / Docker Compose

## 4. Database

### 4.1 DBMS

- PostgreSQL

### 4.2 Main Tables

- users
- roles
- users_roles (user-role join table)
- accounts
- transactions
- notifications
- password_reset_code

### 4.3 Schema Notes

- Hibernate is configured with: spring.jpa.hibernate.ddl-auto=validate
- The application does not auto-create schema, so tables must exist before startup
- Seed base roles (for example: ADMIN, AUDITOR, CUSTOMER) to ensure registration flow works correctly

## 5. Setup Guide

### 5.1 Prerequisites

- JDK 21
- PostgreSQL running
- Maven (or Maven Wrapper)
- Valid SMTP credentials
- AWS S3 credentials (if profile upload is enabled)

### 5.2 Environment Configuration

This project uses a template file named .env.example.

1. Copy .env.example to .env in the project root.

Windows:

```bat
copy .env.example .env
```

Linux/macOS:

```bash
cp .env.example .env
```

2. Edit .env and provide real values for your environment.

The app loads this file via:

- spring.config.import=optional:file:.env[.properties]

### 5.3 Run Locally

Windows:

```bat
mvnw.cmd spring-boot:run
```

Or build and run jar:

```bat
mvnw.cmd clean package -DskipTests
java -jar target\sharkbank-0.0.1-SNAPSHOT.jar
```

Linux/macOS:

```bash
./mvnw spring-boot:run
```

### 5.4 Run with Docker Compose

```bash
docker compose up --build
```

Stop services:

```bash
docker compose down
```

## Main Source Structure

```text
src/main/java/com/shark/sharkbank
  account/             Account domain
  audit_dashboard/     Audit APIs
  auth_users/          Authentication and user management
  aws/                 S3 configuration and service
  configs/             Shared beans
  enums/               Enum definitions
  exceptions/          Exception handling
  notification/        Email and notification logic
  res/                 Response wrapper
  role/                Role management
  security/            JWT and security filters
  transaction/         Transaction domain

src/main/resources
  application.properties
  templates/           Email templates
```

## 6. Demo

- Live demo: http://bank-deploy-bucket.s3-website-us-east-1.amazonaws.com
