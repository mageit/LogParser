# Log Parser
## Table of Contents
- [Project Overview](#project-overview)
- [Recommended Tools](#recommended-tools)
- [Project Requirements](#project-requirements)
  - [Frontend (React Typescript)](#frontend-react-typescript)
  - [Backend (Spring Boot in Kotlin)](#backend-spring-boot-in-kotlin)
- [Directory Structure](#directory-structure)
- [API Endpoint](#api-endpoint)
- [Project Setup](#project-setup)
  - [Frontend Installation](#frontend-installation)
  - [Backend Installation](#backend-installation)
  - [Additional Notes](#additional-notes)
- [Unit test](#unit-test)
  - [Frontend](#frontend)
  - [Backend](#backend)
- [Potential Issue: CORS Errors](#potential-issue-cors-errors)
- [Thank you](#thank-you)

## Project Overview
This project is designed to parse uploaded log files and extract key metrics such as the most active IP address, most visited links, and unique IP addresses. 
It consists of a **frontend** built with **React Typescript** and a **backend** API developed using **Spring Boot in Kotlin**.<br /><br />
This project is built on React typescript and Spring boot, providing a solid foundation for future expansion and customisation.

## Recommended Tools ##
- **IntelliJ IDEA**

## Project Requirements
### Frontend (React Typescript):

Node version 20.14.0 or higher<br />
npm version 10.7.0 or higher

### Backend (Spring Boot in Kotlin):

Java SDK: Version 21 or higher (Amazon Corretto 21 in IntelliJ IDEA)

## Directory Structure
`root (LogParser)`<br>
`├──`[`src`] — A source folder includes both frontend and backend code.<br>
`│   ├──`[`main`] — Contains the kotlin backend code.<br>
`│   ├──`[`test`] — Contains the kotlin backend test code.<br>
`│   ├──`[`frontend`] — Contains the React typescript frontend.<br>
`│   ├───────   └───`[`sample`] — Contains the sample data for testing purpose.<br>
`└───`[`screenshot`] — Contains the screenshots of the webapp.<br>

## API Endpoint 
You can use Postman to test the API endpoint.
- **Endpoint**: /api/v1/parse
- **Method**: POST
- **Request Body**:
  - **Content-Type**: multipart/form-data
  - **Key**: logFile
  - **Value**: A file object representing the log file to be parsed.

## Project Setup
### Frontend Installation
1. Navigate to the frontend directory, assume you are in the root directory:
```bash
cd src/frontend
```

2. Install the required dependencies:
```bash
npm install
```
3. Start the frontend server:
```bash
npm start
```

### Backend Installation
1. Run gradle command, assume you are in the root directory:
```bash
./gradlew bootRun
```

### Additional Notes
For a streamlined development experience, using IntelliJ IDEA is recommended. It simplifies project setup by automatically downloading the required Java SDK.
#### 1. Open the project in IntelliJ IDEA:
- Open the cloned project directory in IntelliJ IDEA.
#### 2. Configure the SDK:
- Press Command + ; to open the Project Structure dialog.
- Go to Project -> Project SDK.
- Select Download SDK and choose corretto-21.
- Click Apply and OK.
#### 3. Run the backend:
- Click the Gradle icon on the right-hand side of the project window.
- Find the bootrun task and double-click it to run the backend.

## Unit test
### Frontend
1. Navigate to the frontend directory, assume you are in the root directory:
```bash
cd src/frontend
```
2. Run the following command:
```bash
npm test
```

### Backend
2. Run the following command, assume you are in the root directory:
```bash
./gradlew test
```

## Potential Issue: CORS Errors
If you're running the frontend on a different port than the default (5173), you may encounter Cross-Origin Resource Sharing (CORS) errors when attempting to communicate with the backend API.

**To resolve this**:
1. Navigate to the CorsConfig class:
   - Locate the CorsConfig class in your backend project, typically located in the `src/main/kotlin/com.jack.logparser` package.
2. Modify the `allowedOrigins` property:
   - Within the `CorsConfig` class, find the `allowedOrigins` property and add the URL of your frontend server. `eg. http://localhost:3000`

## Thank you
I'm happy to help with any questions you might have. Feel free to reach out to me at jzho21@gmail.com. 



