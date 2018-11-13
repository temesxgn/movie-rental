package com.utdallas.movierental.cutomer;

import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPoints;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPointsStrategyFactory;
import com.utdallas.movierental.rental.Rental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private int age;
    private int frequentRenterPoints; //TODO need to update this value whenever a rental is added?
    private List<Rental> rentals;

    public Customer (String name, int age) {
        this.name = name;
        this.age = age;
        this.rentals = new ArrayList<>();
    }
    
    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalChargeAmount() {
        return rentals.stream().mapToDouble(Rental::getChargeAmount).sum();
    }

    public int getTotalFrequentRenterPoints() {
        FrequentRenterPoints customerFrequentRenterPoints = FrequentRenterPointsStrategyFactory.newCustomerFrequentRenterPointsStrategy(this);
        int points = customerFrequentRenterPoints.getPoints() + rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
        frequentRenterPoints += points;
        return points;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public void setFrequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
    }

}