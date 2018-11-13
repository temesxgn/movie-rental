package com.utdallas.movierental;

import com.utdallas.movierental.checkout.CheckoutService;
import com.utdallas.movierental.cutomer.Customer;
import com.utdallas.movierental.movie.Movie;
import com.utdallas.movierental.movie.MovieType;
import com.utdallas.movierental.rental.Rental;
import com.utdallas.movierental.statement.StatementUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRentalApplication {
  private static Logger logger = LoggerFactory.getLogger(MovieRentalApplication.class);

  public static void main(String [] args) {

        CheckoutService checkoutService = new CheckoutService();
		Customer customer = new Customer("Thomas", 21);
		Movie spaceJam = new Movie("Space Jam", MovieType.CHILDRENS);
		Movie gladiator = new Movie("Gladiator", MovieType.NEW_RELEASE);
		Movie oceans11 = new Movie("Oceans 11", MovieType.REGULAR);

        Rental rental1 = new Rental(spaceJam, 1,1);
        Rental rental2 = new Rental(gladiator, 2,2);
        Rental rental3 = new Rental(oceans11, 1,10);

        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        checkoutService.checkout(customer);

        //gladiator.setMovieType(MovieType.REGULAR);
        //checkoutService.checkout(customer); // this should not add the two new strategies for first new frequent rental points
	}
}
