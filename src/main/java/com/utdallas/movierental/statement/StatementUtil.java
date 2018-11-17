package com.utdallas.movierental.statement;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.statement.TextStatement;
import com.utdallas.movierental.statement.XmlStatement;

public final class StatementUtil {

  private StatementUtil() {

  }

  public static String printAsText(Customer customer, Cart cart) {
    return new TextStatement(customer, cart).printStatement();
  }

  public static String printAsXML(Customer customer, Cart cart) {
    return new XmlStatement(customer, cart).printStatement();
  }

}
