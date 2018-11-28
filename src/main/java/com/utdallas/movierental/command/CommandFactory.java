package com.utdallas.movierental.command;

import com.utdallas.movierental.exception.InvalidInputTypeException;

public final class CommandFactory {

    public static Command getCommand(CommandFactoryInput data) throws InvalidInputTypeException {

        Command command;
        switch (data.getCommandType()) {
            case DONE:
               command = new ExitCommand();
                break;
            case PURCHASE:
                command = new HandlePurchaseItemEventCommand(data.getCart());
                break;
            case RENT:
                command = new HandleRentItemEventCommand(data.getCart());
                break;
            case CHECKOUT:
                command = new CheckoutCommand(data.getCart());
                break;
            case EMPTY_CART:
                command = new EmptyCartCommand(data.getCart());
                break;
            case ORDER_HISTORY:
                command = new DisplayOrderHistoryCommand(data.getCustomer());
                break;
            case CUSTOMER_INFO:
                command = new DisplayCustomerInformationCommand(data.getCustomer());
                break;
            case LIST:
                command = new DisplayItemsCommand();
                break;
            default:
                throw new InvalidInputTypeException();
        }

        return command;
    }
}
