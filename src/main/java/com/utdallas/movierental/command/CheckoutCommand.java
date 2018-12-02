package com.utdallas.movierental.command;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.checkoutoption.purchase.Purchase;
import com.utdallas.movierental.checkoutoption.purchase.PurchaseDecoratorHalfOff;
import com.utdallas.movierental.checkoutoption.rental.Rental;
import com.utdallas.movierental.checkoutoption.rental.RentalDecoratorFreeRental;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.service.CheckoutService;
import com.utdallas.movierental.util.ApplicationUtil;

import java.util.Comparator;

public class CheckoutCommand extends BaseCommand {

    private static final int FREE_RENTAL_FCP_MINIMUM = 10;
    private static final int HALF_OFF_PURCHASE_FCP_MINIMUM = 20;
    private Cart cart;
    private Customer customer;

    public CheckoutCommand(Customer customer, Cart cart) {
        super();
        this.customer = customer;
        this.cart = cart;
    }

    @Override
    public void execute() {
        ApplicationUtil.println("Checking out...");

        determineCustomerDiscountEligibility();
        CheckoutService.checkout(customer, cart);
    }

    private void determineCustomerDiscountEligibility() {
        Customer customer = cart.getCustomer();

        boolean isCustomerEligibleForFreeRental = customer.getFrequentCustomerPoints() >= FREE_RENTAL_FCP_MINIMUM
                && cart.getItems().stream().anyMatch(Rental.class::isInstance);

        boolean isCustomerEligibleForHalfOffPurchase = customer.getFrequentCustomerPoints() >= HALF_OFF_PURCHASE_FCP_MINIMUM
                && cart.getItems().stream().anyMatch(Purchase.class::isInstance);

        boolean isCustomerEligibleForFCPDiscount = isCustomerEligibleForFreeRental || isCustomerEligibleForHalfOffPurchase;

        if (isCustomerEligibleForFCPDiscount) {
            askUserForDiscountOption(isCustomerEligibleForFreeRental, isCustomerEligibleForHalfOffPurchase);
        }
    }

    private void askUserForDiscountOption(boolean isCustomerEligibleForFreeRental, boolean isCustomerEligibleForHalfOffPurchase) {
        int numOfDiscounts = isCustomerEligibleForFreeRental ? 0 : 1;
        numOfDiscounts = isCustomerEligibleForHalfOffPurchase ? numOfDiscounts : numOfDiscounts + 1;
        ApplicationUtil.println(String.format("You are eligible for %s discount(s)!", numOfDiscounts));
        ApplicationUtil.println("Please select a discount: ");

        if (isCustomerEligibleForFreeRental) {
            ApplicationUtil.println("[F]ree rental");
        }

        if (isCustomerEligibleForHalfOffPurchase) {
            ApplicationUtil.println("[H]alf off purchase");
        }

        getOptionFromUser();
    }

    private void getOptionFromUser() {
        String option = scanner.nextLine();
        switch (option.toUpperCase()) {
            case "F":
                applyFreeRental();
                break;
            case "H":
                applyHalfOffPurchaseItem();
                break;
            default:
                ApplicationUtil.println("Invalid input, not applying any discounts");
                break;
        }
    }

    private void applyFreeRental() {
        cart.getItems()
            .stream()
            .filter(Rental.class::isInstance)
            .min(Comparator.comparing(CheckoutOption::getChargeAmount))
            .ifPresent(item -> {
                cart.removeItem(item);
                Rental freeRental = new RentalDecoratorFreeRental((Rental) item);
                cart.addItem(freeRental);
                cart.getCustomer().deductFrequentCustomerPoints(FREE_RENTAL_FCP_MINIMUM);
            });
    }

    private void applyHalfOffPurchaseItem() {
        cart.getItems()
            .stream()
            .filter(Purchase.class::isInstance)
            .min(Comparator.comparing(CheckoutOption::getChargeAmount))
            .ifPresent(item -> {
                cart.removeItem(item);
                Purchase halfOffRental = new PurchaseDecoratorHalfOff((Purchase) item);
                cart.addItem(halfOffRental);
                cart.getCustomer().deductFrequentCustomerPoints(HALF_OFF_PURCHASE_FCP_MINIMUM);
            });
    }
}
