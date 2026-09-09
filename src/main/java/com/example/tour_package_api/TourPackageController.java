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
        List<TourPackage> list = new ArrayList<>();
        list.add(make(1L, "Goa Beach Trip", "Goa", 15000, "beach",
            "https://loremflickr.com/400/200/goa,beach", "Taj Holiday Village", "Sleeper from Bangalore", 4.8));
        list.add(make(2L, "Coorg Hills Trip", "Coorg", 12000, "hills",
            "https://loremflickr.com/400/200/coorg,coffee", "Coorg Cliff Resort", "Volvo from Bangalore", 4.7));
        list.add(make(3L, "Gokarna Beach Camp", "Gokarna", 9000, "beach",
            "https://loremflickr.com/400/200/gokarna,beach", "Gokarna Beach Cottages", "Sleeper bus", 4.6));
        list.add(make(4L, "Mysore Palace Tour", "Mysore", 8000, "heritage",
            "https://loremflickr.com/400/200/mysore,palace", "Lalitha Mahal Palace", "Day bus from Bangalore", 4.7));
        list.add(make(5L, "Hampi Heritage Walk", "Hampi", 10000, "heritage",
            "https://loremflickr.com/400/200/hampi,temple", "Hampi Boulders Resort", "Overnight bus", 4.8));
        list.add(make(6L, "Munnar Tea Hills", "Munnar", 14000, "hills",
            "https://loremflickr.com/400/200/munnar,tea", "Tea Valley Resort", "Volvo from Kochi", 4.8));
        list.add(make(7L, "Alleppey Houseboat", "Alleppey", 16000, "backwater",
            "https://loremflickr.com/400/200/alleppey,houseboat", "Houseboat Stay Premium", "Train + cab", 4.9));
        list.add(make(8L, "Ooty Lake & Hills", "Ooty", 11000, "hills",
            "https://loremflickr.com/400/200/ooty,lake", "Ooty Lake Resort", "Bus from Coimbatore", 4.6));
        list.add(make(9L, "Kodaikanal Escape", "Kodaikanal", 10500, "hills",
            "https://loremflickr.com/400/200/kodaikanal", "Kodaikanal Pine Resort", "Bus from Madurai", 4.6));
        list.add(make(10L, "Madurai Temple Tour", "Madurai", 7500, "temple",
            "https://loremflickr.com/400/200/madurai,temple", "Heritage Madurai Hotel", "Train from Chennai", 4.5));
        list.add(make(11L, "Tirupati Darshan", "Tirupati", 7000, "temple",
            "https://loremflickr.com/400/200/tirupati,temple", "MGM Grand Tirupati", "APSRTC bus", 4.7));
        list.add(make(12L, "Araku Valley Trip", "Araku", 9500, "valley",
            "https://loremflickr.com/400/200/araku,valley", "Araku Valley Resort", "Train from Vizag", 4.5));
        return list;
    }

    private TourPackage make(Long id, String name, String dest, double price, String cat,
                             String img, String hotel, String bus, double rating) {
        TourPackage t = new TourPackage();
        t.setId(id); t.setName(name); t.setDestination(dest); t.setPrice(price);
        t.setCategory(cat); t.setImageUrl(img); t.setHotel(hotel); t.setBus(bus); t.setRating(rating);
        return t;
    }
}