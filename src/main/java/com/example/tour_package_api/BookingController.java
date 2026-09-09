package com.example.tour_package_api;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final List<Booking> bookings = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    @PostMapping
    public Booking book(@RequestBody Booking b) {
        b.setId(counter.getAndIncrement());
        bookings.add(b);
        return b;
    }

    @GetMapping
    public List<Booking> all() {
        return bookings;
    }
}
