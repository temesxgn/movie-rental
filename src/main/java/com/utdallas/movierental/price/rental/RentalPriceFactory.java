package com.utdallas.movierental.price.rental;

import com.utdallas.movierental.checkoutoption.rental.RegularRental;
import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.price.Price;
import com.utdallas.movierental.price.PriceFactory;

public final class RentalPriceFactory extends PriceFactory {

  private CategoryType type;
  private int daysRented;

  public RentalPriceFactory(RegularRental option) {
    this.type = option.getCategory();
    this.daysRented = option.getDaysRented();
  }

  @Override
  public Price getPrice() {
    if (type.equals(CategoryType.CHILDRENS) && daysRented > 3) {
      return new PriceChildrensExtendedRental(daysRented);
    } else if (type.equals(CategoryType.CHILDRENS) && daysRented <= 3) {
      return new PriceChildrens();
    } else if (type.equals(CategoryType.NEW_RELEASE)) {
      return new PriceNewRelease(daysRented);
    } else if (type.equals(CategoryType.REGULAR) && daysRented > 2) {
      return new PriceRegularExtendedRental(daysRented);
    } else if (type.equals(CategoryType.REGULAR) && daysRented <= 2) {
      return new PriceRegular();
    } else {
      return new PriceRegular(); //TODO default to regular for now
    }
  }
}
