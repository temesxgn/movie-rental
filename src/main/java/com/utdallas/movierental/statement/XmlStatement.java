package com.utdallas.movierental.statement;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartDecorator;
import com.utdallas.movierental.rental.Rental;

public class XmlStatement extends Statement {

  public XmlStatement(Cart cart) {
    super(cart);
  }

  @Override
  protected String detail(Rental rental) {
    return String.format("<movie>%n\t<title>%s</title>%n\t<chargeAmount>%s</chargeAmount>%n<movie>%n", rental.getMovieTitle(), rental.getChargeAmount());
  }

  @Override
  protected String footer() {
    String footer = String.format("<amountOwed>%s</amountOwed>%n<earnedFrequentRenterPoints>%s</earnedFrequentRenterPoints>%n",
            cart.getTotalChargeAmount(), cart.getTotalFrequentRenterPoints());

    if (cart instanceof CartDecorator) {
      String discount = cart.toString();
      footer = String.format("<discount>%s</discount>%n%s", discount, footer);
    }

    return footer;
  }

  @Override
  protected String header() {
    return String.format("%n<name>%s</name>%n", cart.getName());
  }
}
