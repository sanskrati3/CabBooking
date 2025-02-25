package com.example.cabbooking.model;

public class Driver {
    private String name;
    private String gender;
    private int age;
    private Vehicle vehicle;
    private Location currentLocation;
    private boolean isAvailable;

    // Constructors, Getters, and Setters

    public Driver(String name, String gender, int age, Vehicle vehicle, Location currentLocation, boolean isAvailable) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicle = vehicle;
        this.currentLocation = currentLocation;
        this.isAvailable = isAvailable;
    }

    public Driver() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", vehicle=" + vehicle +
                ", currentLocation=" + currentLocation +
                ", isAvailable=" + isAvailable +
                '}';
    }
}