package orlian.cashier;

public class Cashier{

    private Cash cashRegister;

    public Cashier(Cash cashRegister) {
        this.cashRegister = cashRegister;
    }

    public Cash pay(double price, Cash customerPay) throws NotEnoughChangeException{
        Cash originalCashRegister = new Cash(cashRegister);
        //originalCashRegister = beforeTransaction(cashRegister, originalCashRegister);
        double change = (customerPay.totalCash()) - price;
        if(cashRegister.totalCash() == 0) {
            throw new NotEnoughChangeException();
        }
        try {
            cashRegister = addToRegister(customerPay, cashRegister);
            change = Math.round(change * 100.0) / 100.0;
            Cash cashierTocustomer = cashierReturn(change, cashRegister);
            if (cashierTocustomer.totalCash() != change) {
                throw new NotEnoughChangeException();
            }
            return cashierTocustomer;

        } catch(NotEnoughChangeException exception){ // If there is not enough change, the CashRegister is returns to it's initial state
            cashRegister = originalCashRegister;
            throw new NotEnoughChangeException();
        }
    }


    public Cash beforeTransaction(Cash cashRegister, Cash originalCashRegister){
            originalCashRegister.setTwentyDollars(cashRegister.getTwentyDollars());
            originalCashRegister.setTenDollars(cashRegister.getTenDollars());
            originalCashRegister.setFiveDollars(cashRegister.getFiveDollars());
            originalCashRegister.setDollars(cashRegister.getDollars());
            originalCashRegister.setQuarters(cashRegister.getQuarters());
            originalCashRegister.setDimes(cashRegister.getDimes());
            originalCashRegister.setNickels(cashRegister.getNickels());
            originalCashRegister.setPennies(cashRegister.getPennies());
            return originalCashRegister;
    }


    // Putting the Cash the customer payed into the CashRegister
    public Cash addToRegister(Cash cashPay, Cash cashRegister) {
        for (double num = 20; num <= cashPay.getTwentyDollars(); num += 20) {
            cashRegister.addTwentyDollars();
        }
        for (double num = 10; num <= cashPay.getTenDollars(); num += 10) {
            cashRegister.addTenDollars();
        }
        for (double num = 5; num <= cashPay.getFiveDollars(); num += 5) {
            cashRegister.addFiveDollars();
        }
        for (double num = 1; num <= cashPay.getDollars(); num += 1) {
            cashRegister.addDollars();
        }
        for (double num = .25; num <= cashPay.getQuarters(); num += .25) {
            cashRegister.addQuarters();
        }
        for (double num = .01; num <= cashPay.getDimes(); num += .10) {
            cashRegister.addDimes();
        }
        for (double num = .05; num <= cashPay.getNickels(); num += .05) {
            cashRegister.addNickels();
        }
        for (double num = 0.01; num <= cashPay.getPennies(); num += 0.01) {
            cashRegister.addPennies();
        }
        return cashRegister;
    }

    

    // Returns Cash object with the optimal way to pay customer based on cash found in the register,
    // cashCashier represents the way the Cashier should pay the customer
    public Cash cashierReturn(double change, Cash cashRegister) {
        Cash cashCashier = new Cash(0, 0, 0, 0, 0, 0, 0, 0);

        while ((change - 20 >= 0) && (cashRegister.getTwentyDollars() >= 20)) {
            cashCashier.addTwentyDollars();
            cashRegister.decreaseTwentyDollars();
            change -= 20;
        }
        while ((change - 10 >= 0) && (cashRegister.getTenDollars() >= 10)) {
            cashCashier.addTenDollars();
            cashRegister.decreaseTenDollars();
            change -= 10;
        }
        while ((change - 5 >= 0) && (cashRegister.getFiveDollars() >= 5)) {
            cashCashier.addFiveDollars();
            cashRegister.decreaseFiveDollars();
            change -= 5;
        }
        while ((change - 1 >= 0) && (cashRegister.getDollars() >= 1)) {
            cashCashier.addDollars();
            cashRegister.decreaseDollars();
            change -= 1;
        }
        while ((change - 0.25 >= 0) && (cashRegister.getQuarters() >= 0.25)) {
            cashCashier.addQuarters();
            cashRegister.decreaseQuarters();
            change -= 0.25;
        }
        while ((change - 0.10 >= 0) && (cashRegister.getDimes() >= 0.10)) {
            cashCashier.addDimes();
            cashRegister.decreaseDimes();
            change -= 0.10;
        }
        while ((change - 0.05 >= 0) && (cashRegister.getNickels() >= 0.05)) {
            cashCashier.addNickels();
            cashRegister.decreaseNickels();
            change -= 0.05;
        }
        while ((change - 0.01 >= 0) && (cashRegister.getPennies() >= 0.01)) {
            cashCashier.addPennies();
            cashRegister.decreasePennies();
            change -= 0.01;
        }
        return cashCashier;
    }

    public Cash getCashRegister(){
        return cashRegister;
    }


}
