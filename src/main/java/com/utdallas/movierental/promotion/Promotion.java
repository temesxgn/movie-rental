package com.utdallas.movierental.promotion;

import com.utdallas.movierental.cutomer.Customer;

public interface Promotion {

    boolean canApply(Customer c);
}
