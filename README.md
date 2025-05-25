# Online Coding Platform

A full-stack web application for online coding challenges, built with Spring Boot and React.

## Project Structure

- `backend/`: Spring Boot backend with PostgreSQL database
- `frontend/`: React frontend application

## Technologies Used

### Backend
- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- PostgreSQL
- Lombok

### Frontend
- React 18
- React Router
- Axios
- Monaco Editor

## Getting Started

### Prerequisites
- Java 17 or higher
- Node.js and npm
- PostgreSQL database

### Database Setup
1. Create a PostgreSQL database named `coding_platform`
2. Update the database credentials in `backend/src/main/resources/application.properties` if needed

### Backend Setup
1. Navigate to the backend directory:
   ```
   cd backend
   ```
2. Build the application:
   ```
   ./mvnw clean install
   ```
3. Run the Spring Boot application:
   ```
   ./mvnw spring-boot:run
   ```
   The backend will start on http://localhost:8080

### Frontend Setup
1. Navigate to the frontend directory:
   ```
   cd frontend
   ```
2. Install dependencies:
   ```
   npm install
   ```
3. Start the React development server:
   ```
   npm start
   ```
   The frontend will start on http://localhost:3000

## Features
- Browse coding problems
- Filter problems by difficulty
- Search problems by keyword
- View problem details
- Write and submit code solutions
- Code editor with syntax highlighting
- View submission results
