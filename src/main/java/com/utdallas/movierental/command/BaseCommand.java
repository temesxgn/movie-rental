package com.utdallas.movierental.command;

import java.util.Scanner;

public abstract class BaseCommand implements Command {

    protected Scanner scanner;

    public BaseCommand() {
        scanner = new Scanner(System.in);
    }

    protected boolean isSelectedQuantityAvailable(final int selectedQuantity, final int availableQuantity) {
        return selectedQuantity <= availableQuantity;
    }
}
