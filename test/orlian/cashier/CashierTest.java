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
        Cash cashRegister = new Cash(0, 0, 0, 100, 0, 0, 0, 0);
        Cashier cashier = new Cashier(cashRegister);
        Cash cashCustomerPay = new Cash(0, 0, 0, 0, 3, 0, 0, 0);

        // when
        Cash cashReturn = cashier.pay(2.49, cashCustomerPay);

        // then

    }

    @Test
    public void payNotEnoughChangeCheckRegister() throws NotEnoughChangeException {
        // given
        Cash cashRegister = new Cash(100, 0, 0, 0, 0, 0, 0, 0);
        Cashier cashier = new Cashier(cashRegister);
        Cash cashCustomerPay = new Cash(0, 0, 0, 0, 3, 0, 0, 0);

        // when
        cashRegister = cashier.pay(2.49, cashCustomerPay);

        // then
        assertEquals(0, cashRegister.getDollars(), 0.0001);
        assertEquals(0, cashRegister.getQuarters(), 0.0001);
        assertEquals(0, cashRegister.getDimes(), 0.0001);
        assertEquals(0, cashRegister.getNickels(), 0.0001);
        assertEquals(1, cashRegister.getPennies(), 0.0001);
    }
}