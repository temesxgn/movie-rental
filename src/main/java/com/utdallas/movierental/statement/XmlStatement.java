package com.utdallas.movierental.statement;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartDecorator;
import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.checkoutoption.rental.RentalDecorator;
import com.utdallas.movierental.customer.Customer;

public class XmlStatement extends Statement {

  public XmlStatement(Cart cart) {
    super(cart);
  }

  @Override
  protected String detail(CheckoutOption item) {
    String detail = String.format("<item>%n\t<title>%s</title>%n\t<chargeAmount>%s</chargeAmount>%n<item>%n", item.getTitle(), item.getChargeAmount());
    if (item instanceof RentalDecorator) {
      String promotion = item.toString();
      detail = String.format("<promotion>%s</promotion>%n%s", promotion, detail);
    }

    return detail;
  }

  @Override
  protected String footer(Cart cart) {
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
