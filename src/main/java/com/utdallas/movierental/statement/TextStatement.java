package com.utdallas.movierental.statement;

import com.utdallas.movierental.Customer;
import com.utdallas.movierental.Rental;

public class TextStatement extends Statement {

  public TextStatement(Customer customer) {
    super(customer);
  }

  @Override
  protected String detail(Rental rental) {
    return String.format("\t%s\t%s%n", rental.getMovieTitle(), rental.getChargeAmount());
  }

  @Override
  protected String footer() {
    return String.format("Amount owed is %s.%nYou earned %s frequent renter points",
                         customer.getTotalChargeAmount(), customer.getTotalFrequentRenterPoints());
  }

  @Override
  protected String header() {
    return String.format("%nRental Record for %s%n", customer.getName());
  }
}
