package com.utdallas.movierental.price;

import com.utdallas.movierental.domain.CategoryType;

public final class PriceFactory {

  private PriceFactory() {

  }

  public static Price getPrice(CategoryType type) {
    switch (type) {
      case CHILDRENS:
        return new ChildrensPrice();
      case NEW_RELEASE:
        return new NewReleasePrice();
      case REGULAR:
      default:
        return new RegularPrice();
    }
  }
}
