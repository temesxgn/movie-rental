package com.utdallas.movierental.statement;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cutomer.Customer;

public final class StatementUtil {

  private StatementUtil() {

  }

  public static String asText(Customer customer, Cart cart) {
    return new TextStatement(customer, cart).printStatement();
  }

  public static String asXML(Customer customer, Cart cart) {
    return new XmlStatement(customer, cart).printStatement();
  }

}
