package com.utdallas.movierental.price;

public abstract class Price {

  private static final int RENT_LENGTH = 1;
  private static final int DOUBLE_POINTS = 2;
  private static final int SINGLE_POINT = 1;

  public abstract double getChargeAmount(int daysRented);

  public final int getFrequentRenterPoints(int daysRented) {
    boolean isNewReleaseInstance = this instanceof NewReleasePrice;
    if (isNewReleaseInstance && daysRented > RENT_LENGTH) {
      return DOUBLE_POINTS;
    } else {
      return SINGLE_POINT;
    }
  }

}
