package orlian.cashier;

import org.junit.Test;
import orlian.projectile.Projectile;

import static org.junit.Assert.assertEquals;

public class CashierTest{
    @Test
    public void pay(){
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
}