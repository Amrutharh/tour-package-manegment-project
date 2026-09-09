package com.example.tour_package_api;

import jakarta.persistence.*;

@Entity
@Table(name = "tour_packages")
public class TourPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String destination;
    private double price;
    private String category;
    private String imageUrl;
    private String hotel;
    private String bus;
    private double rating;

    public TourPackage() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getHotel() { return hotel; }
    public void setHotel(String hotel) { this.hotel = hotel; }
    public String getBus() { return bus; }
    public void setBus(String bus) { this.bus = bus; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    private String places;
    private String resorts;
    public String getPlaces() { return places; }
    public void setPlaces(String places) { this.places = places; }
    public String getResorts() { return resorts; }
    public void setResorts(String resorts) { this.resorts = resorts; }
    private String state;
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
}