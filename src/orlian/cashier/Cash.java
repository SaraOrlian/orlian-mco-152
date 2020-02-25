package orlian.cashier;

public class Cash {
    public static final double PENNY = 0.01;
    public static final double NICKEL = 0.05;
    public static final double DIME = 0.10;
    public static final double QUARTER = 0.25;
    public static final double DOLLAR = 1.00;
    public static final double FIVE_DOLLAR = 5.00;
    public static final double TEN_DOLLAR = 10.00;
    public static final double TWENTY_DOLLAR = 20.00;
    private double pennies;
    private double nickels;
    private double dimes;
    private double quarters;
    private double dollars;
    private double fiveDollars;
    private double tenDollars;
    private double twentyDollars;

    public Cash(){}

    public Cash(int numPennies, int numNickels, int numDimes, int numQuarters, int numDollars, int numFiveDollars, int numTenDollars, int numTwentyDollars) {
        pennies = numPennies*PENNY;
        nickels = numNickels*NICKEL;
        dimes = numDimes*DIME;
        quarters = numQuarters*QUARTER;
        dollars = numDollars*DOLLAR;
        fiveDollars = numFiveDollars*FIVE_DOLLAR;
        tenDollars = numTenDollars*TEN_DOLLAR;
        twentyDollars = numTwentyDollars*TWENTY_DOLLAR;
    }

    public double totalCash()
    {
        return (pennies+nickels+dimes+quarters+dollars+fiveDollars+tenDollars+twentyDollars);
    }

    public void addPennies()
    {
        pennies+=.01;
    }

    public void addNickels()
    {
        nickels+=.05;
    }

    public void addDimes()
    {
        dimes+=.10;
    }

    public void addQuarters()
    {
        quarters+=.25;
    }

    public void addDollars()
    {
        dollars+=1;
    }

    public void addFiveDollars()
    {
        fiveDollars+=5;
    }

    public void addTenDollars()
    {
        tenDollars+=10;
    }

    public void addTwentyDollars()
    {
        twentyDollars+=20;
    }

    public void decreasePennies()
    {
        pennies-=.01;
    }

    public void decreaseNickels()
    {
        nickels-=.05;
    }

    public void decreaseDimes()
    {
        dimes-=.10;
    }

    public void decreaseQuarters()
    {
        quarters-=.25;
    }

    public void decreaseDollars()
    {
        dollars-=1;
    }

    public void decreaseFiveDollars()
    {
        fiveDollars-=5;
    }

    public void decreaseTenDollars()
    {
        tenDollars-=10;
    }

    public void decreaseTwentyDollars()
    {
        twentyDollars-=20;
    }

    public double getPennies() {
        return pennies;
    }

    public double getNickels() {
        return nickels;
    }

    public double getDimes() {
        return dimes;
    }

    public double getQuarters() {
        return quarters;
    }

    public double getDollars() {
        return dollars;
    }

    public double getFiveDollars() {
        return fiveDollars;
    }

    public double getTenDollars() {
        return tenDollars;
    }

    public double getTwentyDollars() {
        return twentyDollars;
    }
}
