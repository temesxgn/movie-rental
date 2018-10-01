package com.utdallas.movierental.statement;

import com.utdallas.movierental.Customer;

public final class StatementUtil {

  private StatementUtil() {

  }

  public static String asText(Customer customer) {
    return new TextStatement(customer).printStatement();
  }

  public static String asXML(Customer customer) {
    return new XmlStatement(customer).printStatement();
  }

}
