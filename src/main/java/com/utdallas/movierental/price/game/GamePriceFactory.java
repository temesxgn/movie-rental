package com.utdallas.movierental.price.game;

import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.price.Price;
import com.utdallas.movierental.price.PriceFactory;

public final class GamePriceFactory extends PriceFactory {

  private CategoryType type;

  public GamePriceFactory(CategoryType categoryType) {
    this.type = categoryType;
  }

  public Price getPrice() {
    return getPrice(type);
  }

  private static Price getPrice(final CategoryType type) {
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
