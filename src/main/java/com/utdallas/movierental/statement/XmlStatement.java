package com.utdallas.movierental.statement;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartDecorator;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.rental.Rental;
import com.utdallas.movierental.rental.RentalDecorator;

public class XmlStatement extends Statement {

  public XmlStatement(Customer customer, Cart cart) {
    super(customer, cart);
  }

  @Override
  protected String detail(Rental rental) {
    String detail = String.format("<movie>%n\t<title>%s</title>%n\t<chargeAmount>%s</chargeAmount>%n<movie>%n", rental.getMovieTitle(), rental.getChargeAmount());
    if (rental instanceof RentalDecorator) {
      String promotion = rental.toString();
      detail = String.format("<promotion>%s</promotion>%n%s", promotion, detail);
    }

    return detail;
  }

  @Override
  protected String footer(Customer customer, Cart cart) {
    String footer = String.format("<amountOwed>%s</amountOwed>%n<earnedFrequentRenterPoints>%s</earnedFrequentRenterPoints>%n",
            cart.getTotalChargeAmount(), cart.getTotalFrequentRenterPoints());

    if (cart instanceof CartDecorator) {
      String discount = cart.toString();
      footer = String.format("<discount>%s</discount>%n%s", discount, footer);
    }

    return footer;
  }

  @Override
  protected String header(Customer customer) {
    return String.format("%n<name>%s</name>%n", customer.getName());
  }
}
