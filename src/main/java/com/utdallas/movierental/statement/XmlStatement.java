package com.utdallas.movierental.statement;

import com.utdallas.movierental.Customer;
import com.utdallas.movierental.Rental;

public class XmlStatement extends Statement {

  public XmlStatement(Customer customer) {
    super(customer);
  }

  @Override
  protected String detail(Rental rental) {
    return String.format("<movie>%n\t<title>%s</title>%n\t<chargeAmount>%s</chargeAmount>%n<movie>%n", rental.getMovieTitle(), rental.getChargeAmount());
  }

  @Override
  protected String footer() {
    return String.format("<amountOwed>%s</amountOwed>%n<earnedFrequentRenterPoints>%s</earnedFrequentRenterPoints>%n",
                         customer.getTotalChargeAmount(), customer.getTotalFrequentRenterPoints());
  }

  @Override
  protected String header() {
    return String.format("%n<name>%s</name>%n", customer.getName());
  }
}
