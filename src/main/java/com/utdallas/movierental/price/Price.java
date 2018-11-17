package com.utdallas.movierental.price;

import java.math.BigDecimal;

//TODO Separate days rented to strategy like frequent renter points?
public interface Price {

    BigDecimal getChargeAmount(int daysRented);

}
