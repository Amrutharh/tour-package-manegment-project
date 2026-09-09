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

    @GetMapping("/{id}")
    public TourPackage byId(@PathVariable Long id) {
        for (TourPackage t : getSampleTours()) {
            if (t.getId().equals(id)) return t;
        }
        return null;
    }

    private List<TourPackage> getSampleTours() {
        List<TourPackage> list = new ArrayList<>();
        list.add(make(1L, "Goa Beach Trip", "Goa", "Goa", 3500, "beach",
            "https://loremflickr.com/400/200/goa,beach", "Taj Holiday Village", "Sleeper from Bangalore", 4.8,
            "Baga Beach, Aguada Fort, Basilica of Bom Jesus, Anjuna Market",
            "Taj Holiday Village, W Goa, Baga Paradise Resort"));
        list.add(make(2L, "Coorg Hills Trip", "Coorg", "Karnataka", 2800, "hills",
            "https://loremflickr.com/400/200/coorg,coffee", "Coorg Cliff Resort", "Volvo from Bangalore", 4.7,
            "Abbey Falls, Raja's Seat, Dubare Elephant Camp, Namdroling Monastery",
            "Coorg Cliff Resort, Tamara Coorg, Club Mahindra Coorg"));
        list.add(make(3L, "Gokarna Beach Camp", "Gokarna", "Karnataka", 2200, "beach",
            "https://loremflickr.com/400/200/gokarna,beach", "Gokarna Beach Cottages", "Sleeper bus", 4.6,
            "Om Beach, Mahabaleshwar Temple, Kudle Beach, Mirjan Fort",
            "Gokarna Beach Cottages, SwaSwara, Om Beach Resort"));
        list.add(make(4L, "Mysore Palace Tour", "Mysore", "Karnataka", 1800, "heritage",
            "https://loremflickr.com/400/200/mysore,palace", "Lalitha Mahal Palace", "Day bus from Bangalore", 4.7,
            "Mysore Palace, Chamundi Hills, Brindavan Gardens, St Philomena Church",
            "Lalitha Mahal, Radisson Blu Mysore, Fortune JP Palace"));
        list.add(make(5L, "Hampi Heritage Walk", "Hampi", "Karnataka", 2500, "heritage",
            "https://loremflickr.com/400/200/hampi,temple", "Hampi Boulders Resort", "Overnight bus", 4.8,
            "Virupaksha Temple, Vittala Temple, Hampi Bazaar, Matanga Hill",
            "Hampi Boulders, GoStops Hampi, Virupaksha Guest House"));
        list.add(make(6L, "Munnar Tea Hills", "Munnar", "Kerala", 3200, "hills",
            "https://loremflickr.com/400/200/munnar,tea", "Tea Valley Resort", "Volvo from Kochi", 4.8,
            "Eravikulam Park, Tea Museum, Mattupetty Dam, Top Station",
            "Tea Valley Resort, Fragrant Nature, Blanket Hotel"));
        list.add(make(7L, "Alleppey Houseboat", "Alleppey", "Kerala", 4000, "backwater",
            "https://loremflickr.com/400/200/alleppey,houseboat", "Houseboat Stay Premium", "Train + cab", 4.9,
            "Vembanad Lake, Houseboat Cruise, Alappuzha Beach, Marari Beach",
            "Punnamada Resort, Ramada Alleppey, Houseboat Premium"));
        list.add(make(8L, "Ooty Lake & Hills", "Ooty", "Tamil Nadu", 2600, "hills",
            "https://loremflickr.com/400/200/ooty,lake", "Ooty Lake Resort", "Bus from Coimbatore", 4.6,
            "Ooty Lake, Botanical Gardens, Doddabetta Peak, Nilgiri Toy Train",
            "Ooty Lake Resort, Savoy Ooty, Sterling Ooty"));
        list.add(make(9L, "Kodaikanal Escape", "Kodaikanal", "Tamil Nadu", 2400, "hills",
            "https://loremflickr.com/400/200/kodaikanal", "Kodaikanal Pine Resort", "Bus from Madurai", 4.6,
            "Kodaikanal Lake, Coaker's Walk, Bryant Park, Pillar Rocks",
            "Pine Resort, Sterling Kodai, The Carlton"));
        list.add(make(10L, "Madurai Temple Tour", "Madurai", "Tamil Nadu", 1500, "temple",
            "https://loremflickr.com/400/200/madurai,temple", "Heritage Madurai Hotel", "Train from Chennai", 4.5,
            "Meenakshi Temple, Thirumalai Nayakar Palace, Gandhi Museum, Alagar Hills",
            "Heritage Madurai, Courtyard Marriott, JC Residency"));
        list.add(make(11L, "Tirupati Darshan", "Tirupati", "Andhra Pradesh", 1200, "temple",
            "https://loremflickr.com/400/200/tirupati,temple", "MGM Grand Tirupati", "APSRTC bus", 4.7,
            "Tirumala Temple, Kapila Theertham, Chandragiri Fort, Deer Park",
            "MGM Grand, Fortune Select Tirupati, Bliss Tirupati"));
        list.add(make(12L, "Araku Valley Trip", "Araku", "Andhra Pradesh", 2000, "valley",
            "https://loremflickr.com/400/200/araku,valley", "Araku Valley Resort", "Train from Vizag", 4.5,
            "Borra Caves, Katiki Waterfalls, Coffee Museum, Tribal Museum",
            "Araku Valley Resort, Haritha Mayuri, Ushasri Resort"));
        return list;
    }

    private TourPackage make(Long id, String name, String dest, String state, double price, String cat,
                             String img, String hotel, String bus, double rating,
                             String places, String resorts) {
        TourPackage t = new TourPackage();
        t.setId(id); t.setName(name); t.setDestination(dest); t.setState(state); t.setPrice(price);
        t.setCategory(cat); t.setImageUrl(img); t.setHotel(hotel); t.setBus(bus); t.setRating(rating);
        t.setPlaces(places); t.setResorts(resorts);
        return t;
    }
}
