package com.utdallas.movierental.customer;

import com.utdallas.movierental.transaction.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {

    private String customerId;
    private String name;
    private int age;
    private int frequentRenterPoints;
    private List<Order> orderHistory;

    public Customer(String name, int age) {
        this.customerId = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.orderHistory = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
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

    public void addOrder(Order order) {
        this.orderHistory.add(order);
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }
}