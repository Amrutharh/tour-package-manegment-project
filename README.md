# Tour Package API ✈️

Smart Tour Package REST API with recommend + booking + beautiful UI.

## Features
- GET /api/tours - all tours
- GET /api/tours/recommend?category=beach&maxPrice=10000 - smart filter
- POST /api/bookings - book a tour {tourId, name, date}
- GET /api/bookings - all bookings
- Web UI at / - search + book

## Run
```
.\mvnw.cmd spring-boot:run
```
Open: http://localhost:8080/

## Tech
Java 17, Spring Boot 3.3.4, Maven, REST API
