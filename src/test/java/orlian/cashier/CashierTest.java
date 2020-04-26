package orlian.cashier;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class CashierTest {
    @Test
    public void pay() throws NotEnoughChangeException {
        // given
        Cash cashRegister = new Cash(100, 0, 0, 100, 0, 0, 0, 0);
        Cashier cashier = new Cashier(cashRegister);
        Cash cashCustomerPay = new Cash(0, 0, 0, 0, 3, 0, 0, 0);


        // when
        Cash cashReturn = cashier.pay(2.49, cashCustomerPay);

        // then
        assertEquals(.50, cashReturn.getQuarters(), 0.0001);
        assertEquals(.01, cashReturn.getPennies(), 0.0001);
        assertEquals(24.5, cashRegister.getQuarters(), 0.0001);
        assertEquals(.99, cashRegister.getPennies(), 0.0001);
        assertEquals(3, cashRegister.getDollars(), 0.0001);
    }

    @Test(expected = NotEnoughChangeException.class)
    public void payCashierBroke() throws NotEnoughChangeException {
        // given
        Cashier cashier = new Cashier(new Cash());
        Cash cashCustomerPay = new Cash(0, 0, 0, 0, 3, 0, 0, 0);

        // when
        Cash cashReturn = cashier.pay(2.49, cashCustomerPay);

        // then
    }

    @Test(expected = NotEnoughChangeException.class)
    public void payNotEnoughChange() throws NotEnoughChangeException {
        // given
        Cash cashRegister = new Cash(0, 0, 0, 0, 0, 0, 0, 0);
        Cashier cashier = new Cashier(cashRegister);
        Cash cashCustomerPay = new Cash(0, 0, 0, 0, 3, 0, 0, 0);

        // when
        Cash cashReturn = cashier.pay(2.49, cashCustomerPay);

        // then

    }

    @Test//(expected = NotEnoughChangeException.class)
    public void payNotEnoughChangeCheckRegister() throws NotEnoughChangeException {
        // given
        Cash cashRegister = new Cash(100, 0, 0, 0, 0, 0, 0, 0);
        Cashier cashier = new Cashier(cashRegister);
        Cash cashCustomerPay = new Cash(0, 0, 0, 0, 3, 0, 0, 0);

        // when
        try {
            Cash returnToCustomer = cashier.pay(2.49, cashCustomerPay);

            // then
        } catch (NotEnoughChangeException ex) {
            assertEquals(0, cashier.getCashRegister().getDollars(), 0.0001);
            assertEquals(0, cashier.getCashRegister().getQuarters(), 0.0001);
            assertEquals(0, cashier.getCashRegister().getDimes(), 0.0001);
            assertEquals(0, cashier.getCashRegister().getNickels(), 0.0001);
            assertEquals(1, cashier.getCashRegister().getPennies(), 0.0001);
        }
    }
}