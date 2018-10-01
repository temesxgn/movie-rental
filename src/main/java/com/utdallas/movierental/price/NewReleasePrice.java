package com.utdallas.movierental.price;

public class NewReleasePrice extends Price {

  private static final double CHARGE_MULTIPLIER = 3;

  @Override
  public double getChargeAmount(int daysRented) {
    return daysRented * CHARGE_MULTIPLIER;
  }
}
