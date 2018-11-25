package com.utdallas.movierental.customer;

public class CustomerBuilder {

    private String name;
    private int age;

    public CustomerBuilder(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public Customer build() {
        return new Customer(name, age);
    }
}
