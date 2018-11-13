package com.utdallas.movierental.statement;

import com.utdallas.movierental.cart.Cart;

public final class StatementUtil {

  private StatementUtil() {

  }

  public static String asText(Cart cart) {
    return new TextStatement(cart).printStatement();
  }

  public static String asXML(Cart cart) {
    return new XmlStatement(cart).printStatement();
  }

}
