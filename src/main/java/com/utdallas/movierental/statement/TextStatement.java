package com.utdallas.movierental.statement;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartDecorator;
import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.checkoutoption.rental.RentalDecorator;
import com.utdallas.movierental.util.NumberUtils;

public class TextStatement extends Statement {

  public TextStatement(Cart cart) {
    super(cart);
  }

  @Override
  protected String detail(CheckoutOption item) {
    return String.format("\t%s\t$%s%n", item.getTitle(), NumberUtils.formatTwoDecimalPlaces(item.getChargeAmount()));
  }

  @Override
  protected String footer(Cart cart) {
    String footer = String.format("Amount owed: $%s%nYou earned %s frequent customer points.%nTotal frequent customer points: %s",
            cart.getTotalChargeAmount(), cart.getTotalFrequentCustomerPoints(), cart.getCustomer().getFrequentCustomerPoints());

    if (cart instanceof CartDecorator) {
        String discount = cart.toString();
        footer = String.format("%s discount has been applied! %n%s", discount, footer);
    }

    CheckoutOption rental = cart.getItems().stream().filter(r -> r instanceof RentalDecorator).findFirst().orElse(null);

    if (rental != null) {
      String promotion = rental.toString();
      footer = String.format("%s promotion has been applied to %s! %n%s", promotion, rental.getTitle(), footer);
    }

    return footer;
  }

  @Override
  protected String header(Customer customer) {
    return String.format("%nRental Record for %s%n", customer.getName());
  }
}
