package com.utdallas.movierental.price;

public class ChildrensPrice extends Price {

  private static final int EXTENDED_RENT_LENGTH = 3;
  private static final double CHARGE_AMOUNT = 1.5;

  @Override
  public double getChargeAmount(int daysRented) {
    double chargeAmount = CHARGE_AMOUNT;
    if (daysRented > EXTENDED_RENT_LENGTH) {
      chargeAmount += (daysRented - EXTENDED_RENT_LENGTH) * CHARGE_AMOUNT;
    }

    return chargeAmount;
  }
}
