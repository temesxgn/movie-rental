package com.utdallas.movierental;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.RegularCart;
import com.utdallas.movierental.checkout.CheckoutService;
import com.utdallas.movierental.cutomer.Customer;
import com.utdallas.movierental.movie.Movie;
import com.utdallas.movierental.movie.MovieType;
import com.utdallas.movierental.rental.RegularRental;
import com.utdallas.movierental.rental.Rental;
import com.utdallas.movierental.statement.StatementUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class MovieRentalApplication {
    private static Logger logger = LoggerFactory.getLogger(MovieRentalApplication.class);

    public static void main(String[] args) {

        Customer customer = new Customer("Thomas", 21);

        Movie spaceJam = new Movie("Space Jam", MovieType.CHILDRENS);
        Movie gladiator = new Movie("Gladiator", MovieType.NEW_RELEASE);
        Movie oceans11 = new Movie("Oceans 11", MovieType.REGULAR);
        Movie oceans12 = new Movie("Oceans 12", MovieType.NEW_RELEASE);
        Movie oceans13 = new Movie("Oceans 13", MovieType.NEW_RELEASE);

        Rental rental1 = new RegularRental(spaceJam, 1);
        Rental rental2 = new RegularRental(gladiator, 2);
        Rental rental3 = new RegularRental(oceans11, 3);
        Rental rental4 = new RegularRental(oceans12, 3);
        Rental rental5 = new RegularRental(oceans13, 3);
        ArrayList<Rental> rentals = new ArrayList<>(Arrays.asList(rental1, rental2, rental3, rental4, rental5));

        CheckoutService.checkout(customer, rentals);

        Rental rental = new RegularRental(gladiator, 4);
        rentals = new ArrayList<>(Collections.singletonList(rental));
        CheckoutService.checkout(customer, rentals); // this should not add the two new strategies for first new frequent rental points

    }
}
