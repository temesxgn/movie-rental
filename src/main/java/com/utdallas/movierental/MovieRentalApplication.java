package com.utdallas.movierental;

import com.utdallas.movierental.checkout.CheckoutService;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.domain.Game;
import com.utdallas.movierental.domain.Movie;
import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.rental.RegularRental;
import com.utdallas.movierental.rental.Rental;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class MovieRentalApplication {

    public static void main(String[] args) {

        Customer customer = new Customer("Thomas", 21);

        Movie spaceJam = new Movie("Space Jam", CategoryType.CHILDRENS);
        Movie gladiator = new Movie("Gladiator", CategoryType.NEW_RELEASE);
        Movie oceans11 = new Movie("Oceans 11", CategoryType.REGULAR);
        Movie oceans12 = new Movie("Oceans 12", CategoryType.NEW_RELEASE);
        Movie oceans13 = new Movie("Oceans 13", CategoryType.NEW_RELEASE);
        Game kingdomHearts = new Game("Kingdom Hearts 3", CategoryType.NEW_RELEASE);

        Rental rental1 = new RegularRental(customer.getCustomerId(), spaceJam, 1);
        Rental rental2 = new RegularRental(customer.getCustomerId(), gladiator, 2);
        Rental rental3 = new RegularRental(customer.getCustomerId(), oceans11, 3);
        Rental rental4 = new RegularRental(customer.getCustomerId(), oceans12, 3);
        Rental rental5 = new RegularRental(customer.getCustomerId(), oceans13, 3);
        Rental rental6 = new RegularRental(customer.getCustomerId(), kingdomHearts, 3);

        ArrayList<Rental> rentals = new ArrayList<>(Arrays.asList(rental1, rental2, rental3, rental4, rental5));
        CheckoutService.checkout(customer, rentals); // Additional Decorator

        rentals = new ArrayList<>(Arrays.asList(rental1, rental2, rental3, rental4, rental5, rental6));
        CheckoutService.checkout(customer, rentals); // Half Off Decorator

        Rental rental = new RegularRental(customer.getCustomerId(), gladiator, 4);
        rentals = new ArrayList<>(Collections.singletonList(rental));
        CheckoutService.checkout(customer, rentals); // this should not add the two new strategies based off customer info

    }
}
