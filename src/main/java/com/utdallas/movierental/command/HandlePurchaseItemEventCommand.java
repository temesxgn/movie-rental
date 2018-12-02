package com.utdallas.movierental.command;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.checkoutoption.CheckoutOptionFactory;
import com.utdallas.movierental.checkoutoption.purchase.Purchase;
import com.utdallas.movierental.database.Entry;
import com.utdallas.movierental.domain.ItemFactory;
import com.utdallas.movierental.domain.PurchasableItem;
import com.utdallas.movierental.domain.RentableItem;
import com.utdallas.movierental.service.DatabaseService;
import com.utdallas.movierental.util.ApplicationUtil;

public class HandlePurchaseItemEventCommand extends BaseCommand {

    private Cart cart;

    public HandlePurchaseItemEventCommand(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        ApplicationUtil.println("Select item to purchase");
        ApplicationUtil.print("Item ID: ");
        int id = scanner.nextInt();
        DatabaseService.findById(id).ifPresent(entry -> {
            if (entry.getItem() instanceof PurchasableItem) {
                askUserForQuantityAndAddToCart(entry);
            } else {
                ApplicationUtil.println("Item with id: " + entry.getId() + " is not purchasable");
            }
        });
    }

    private void askUserForQuantityAndAddToCart(Entry entry) {
        ApplicationUtil.println("How many " + entry.getItem().getTitle() + " would you like to purchase?");
        int selectedQuantity = scanner.nextInt();
        scanner.nextLine();

        if (!isSelectedQuantityAvailable(selectedQuantity, entry.getAvailableQuantity())) {
            ApplicationUtil.println(String.format("Error, there are only %s available.", entry.getAvailableQuantity()));
        } else {
            addItemToCartNTimesAndUpdateDatabase(entry, selectedQuantity);
            ApplicationUtil.println(selectedQuantity + " of " + entry.getItem().getTitle() + " has been added to your cart.");
        }
    }

    private void addItemToCartNTimesAndUpdateDatabase(Entry entry, int selectedQuantity) {
        for (int i = 0; i < selectedQuantity; i++) {
            cart.addItem(CheckoutOptionFactory.createPurchaseItem(cart.getCustomer(), entry.getItem()));
        }

        DatabaseService.deductAvailabilityAmountForEntry(entry.getId(), selectedQuantity);
    }
}
