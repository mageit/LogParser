# Log Parser
## Project Overview
This project is designed to parse uploaded log files and extract key metrics such as the most active IP address, most visited links, and unique IP addresses. 
It consists of a **frontend** built with **React Typescript** and a **backend** API developed using **Spring Boot in Kotlin**.<br /><br />
This project is built on React typescript and Spring boot, providing a solid foundation for future expansion and customisation.

## Recommended Tools ##
- **IntelliJ IDEA**

## Project Requirements
### Frontend (React Typescript):

Node.js: Version 20.14.0 or higher
npm: Version 10.7.0 or higher

### Backend (Spring Boot in Kotlin):

Java SDK: Version 21 or higher (Amazon Corretto 21 in IntelliJ IDEA)

## Directory Structure
`root`<br>
`├──`[`src`] — A source folder includes both frontend and backend code.<br>
`│   ├──`[`main`] — Contains the kotlin backend code.<br>
`│   ├──`[`test`] — Contains the kotlin backend test code.<br>
`└- ──`[`frontend`] — Contains the React typescript frontend.<br>


## Project Setup
### Frontend Installation
1. Navigate to the frontend directory:
```bash
cd frontend
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
1. Go to the root directory:
```bash
cd LogParser
```
2. Run gradle command
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
1. Navigate to the frontend directory:
```bash
cd frontend
```
2. Run the following command:
```bash
npm test
```

### Backend
1. Navigate to the root directory:
```bash
cd LogParser
```
2. Run the following command:
```bash
./gradlew test
```

## Thank you
I'm happy to help with any questions you might have. Feel free to reach out to me at jzho21@gmail.com. 



