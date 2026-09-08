package com.example.tour_package_api;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/tours")
public class TourPackageController {

    @GetMapping
    public List<TourPackage> getAllTours() {
        return getSampleTours();
    }

    @GetMapping("/recommend")
    public List<TourPackage> recommend(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double maxPrice) {
        List<TourPackage> result = new ArrayList<>();
        for (TourPackage t : getSampleTours()) {
            boolean ok = true;
            if (category != null && !t.getCategory().equalsIgnoreCase(category)) {
                ok = false;
            }
            if (maxPrice != null && t.getPrice() > maxPrice) {
                ok = false;
            }
            if (ok) {
                result.add(t);
            }
        }
        return result;
    }

    private List<TourPackage> getSampleTours() {
        TourPackage t1 = new TourPackage();
        t1.setId(1L);
        t1.setName("Goa Beach Trip");
        t1.setDestination("Goa");
        t1.setPrice(15000);
        t1.setCategory("beach");

        TourPackage t2 = new TourPackage();
        t2.setId(2L);
        t2.setName("Coorg Hills Trip");
        t2.setDestination("Coorg");
        t2.setPrice(12000);
        t2.setCategory("hills");

        TourPackage t3 = new TourPackage();
        t3.setId(3L);
        t3.setName("Gokarna Beach Camp");
        t3.setDestination("Gokarna");
        t3.setPrice(9000);
        t3.setCategory("beach");

        return Arrays.asList(t1, t2, t3);
    }
}