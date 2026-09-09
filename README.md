# Tour Package API ✈️ — South India Tours

🌐 **Live Demo (click and try): https://tour-package-manegment-project.onrender.com/**

Smart Tour Package REST API with 12 South India tours, recommend, booking with per-person pricing, state grouping, photos, hotels, bus info, trip dates + Admin page.

## Try Live
- Tours: https://tour-package-manegment-project.onrender.com/
- Admin bookings: https://tour-package-manegment-project.onrender.com/admin.html
- API: https://tour-package-manegment-project.onrender.com/api/tours

## Features
- 12 tours: Goa, Karnataka (4), Kerala (2), Tamil Nadu (3), Andhra Pradesh (2)
- Click tour → famous places + top resorts popup
- Search + state grouping + photos + ratings
- Booking with people count: total = price/person x people + trip date
- Admin page with photos: /admin.html
- GET /api/tours, /api/tours/{id}, /api/tours/recommend?category=&maxPrice=
- POST /api/bookings {tourId, name, date, numPeople, totalAmount}

## Run Locally
```
.\mvnw.cmd spring-boot:run
```
Open: http://localhost:8080/

## Tech
Java 17, Spring Boot 3.3.4, Maven, REST API, HTML/CSS/JS
