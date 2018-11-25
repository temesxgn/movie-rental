package com.utdallas.movierental.command;

import com.utdallas.movierental.database.Database;
import com.utdallas.movierental.service.DatabaseService;

public class DisplayItemsCommand implements Command {

    public DisplayItemsCommand() {
    }

    @Override
    public void execute() {
        DatabaseService.printAvailableItems(); //TODO maybe move printing to another class?
    }
}
