package com.utdallas.movierental;

import com.utdallas.movierental.exception.IllegalMovieTypeException;
import com.utdallas.movierental.movie.Movie;
import com.utdallas.movierental.movie.MovieType;
import com.utdallas.movierental.statement.StatementUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRentalApplication {
  private static Logger logger = LoggerFactory.getLogger(MovieRentalApplication.class);

  public static void main(String [] args) {
		Customer customer = new Customer("Thomas");
		Movie spaceJam = new Movie("Space Jam", MovieType.CHILDRENS);
		Movie gladiator = new Movie("Gladiator", MovieType.NEW_RELEASE);
		Movie oceans11 = new Movie("Oceans 11", MovieType.NEW_RELEASE);

		try {
			Rental rental1 = new Rental(spaceJam, 1);
			Rental rental2 = new Rental(gladiator, 2);
			Rental rental3 = new Rental(oceans11, 10);

			customer.addRental(rental1);
			customer.addRental(rental2);
			customer.addRental(rental3);

			if (logger.isDebugEnabled()) {
				logger.info(StatementUtil.asText(customer));
				logger.info(StatementUtil.asXML(customer));
			}

		} catch (IllegalMovieTypeException e) {
			logger.error(e.getMessage());
		}
	}
}
