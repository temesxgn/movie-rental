package com.utdallas.movierental.statement;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartDecorator;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.rental.Rental;
import com.utdallas.movierental.rental.RentalDecorator;
import com.utdallas.movierental.util.NumberUtils;

public class TextStatement extends Statement {

  public TextStatement(Customer customer, Cart cart) {
    super(customer, cart);
  }

  @Override
  protected String detail(Rental rental) {
    return String.format("\t%s\t$%s%n", rental.getMovieTitle(), NumberUtils.formatTwoDecimalPlaces(rental.getChargeAmount()));
  }

  @Override
  protected String footer(Customer customer, Cart cart) {
    String footer = String.format("Amount owed: $%s%nYou earned %s frequent renter points.%nTotal frequent renter points: %s",
            cart.getTotalChargeAmount(), cart.getTotalFrequentRenterPoints(), customer.getFrequentRenterPoints());

    if (cart instanceof CartDecorator) {
        String discount = cart.toString();
        footer = String.format("%s discount has been applied! %n%s", discount, footer);
    }

    Rental rental = cart.getItems().stream().filter(r -> r instanceof RentalDecorator).findFirst().orElse(null);

    if (rental != null) {
      String promotion = rental.toString();
      footer = String.format("%s promotion has been applied to %s! %n%s", promotion, rental.getMovieTitle(), footer);
    }

    return footer;
  }

  @Override
  protected String header(Customer customer) {
    return String.format("%nRental Record for %s%n", customer.getName());
  }
}
