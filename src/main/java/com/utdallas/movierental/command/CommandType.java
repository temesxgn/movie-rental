package com.utdallas.movierental.command;

import com.utdallas.movierental.exception.InvalidInputTypeException;

public enum CommandType {

    DONE("D"),
    LIST("L"),
    PURCHASE("P"),
    RENT("R"),
    CHECKOUT("C"),
    EMPTY_CART("E"),
    ORDER_HISTORY("O"),
    CUSTOMER_INFO("I");

    private String code;
    CommandType(String c) {
        this.code = c;
    }

    public String getCode() {
        return code;
    }

    public static CommandType findByCode(String code) throws InvalidInputTypeException {
        for(CommandType v : values()){
            if( v.getCode().equalsIgnoreCase(code)){
                return v;
            }
        }

        throw new InvalidInputTypeException();
    }
}
