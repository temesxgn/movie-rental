package com.utdallas.movierental.command;

import com.utdallas.movierental.exception.InvalidCommandTypeException;

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

    public static CommandType findByCode(String code) throws InvalidCommandTypeException {
        for(CommandType c : values()){
            if (c.getCode().equalsIgnoreCase(code)){
                return c;
            }
        }

        throw new InvalidCommandTypeException();
    }
}
