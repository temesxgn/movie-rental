package com.utdallas.movierental.cutomer;

public class Customer {
    private String name;
    private int age;
    private int frequentRenterPoints;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void addFrequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints += frequentRenterPoints;
    }

    public void deductFrequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints -= frequentRenterPoints;
    }

}