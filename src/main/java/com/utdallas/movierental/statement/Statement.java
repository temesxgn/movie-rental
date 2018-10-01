package com.utdallas.movierental.statement;

import com.utdallas.movierental.Customer;
import com.utdallas.movierental.Rental;

public abstract class Statement {

  protected Customer customer;

  public Statement(Customer customer) {
    this.customer = customer;
  }

  public String printStatement() {
    StringBuilder builder = new StringBuilder();
    builder.append(header());
    customer.getRentals().forEach(rental -> builder.append(detail(rental)));
    builder.append(footer());
    return builder.toString();
  }

  protected abstract String detail(Rental rental);

  protected abstract String footer();

  protected abstract String header();
}
