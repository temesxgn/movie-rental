package com.utdallas.movierental.command;

import com.utdallas.movierental.util.ApplicationUtil;

public class ExitCommand extends BaseCommand {

    @Override
    public void execute() {
        ApplicationUtil.println("Exiting...");
        System.exit(0);
    }
}
