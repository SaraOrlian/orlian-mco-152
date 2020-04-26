package orlian.cashier;

import javax.management.openmbean.InvalidOpenTypeException;
import javax.swing.*;
import java.awt.*;

public class CashierFrame extends JFrame {

    //<editor-fold desc="Instantiate variables">
    private JButton pennies;
    private JButton nickels;
    private JButton dimes;
    private JButton quarters;
    private JButton oneDollars;
    private JButton fiveDollars;
    private JButton tenDollars;
    private JButton twentyDollars;
    private JLabel priceLabel;
    private JTextField price;
    private JButton clear;
    private JButton pay;
    private JLabel register;
    private JLabel changeLabel;
    private JLabel change;

    private JLabel penniesReg;
    private JLabel nickelsReg;
    private JLabel dimesReg;
    private JLabel quartersReg;
    private JLabel oneDollarsReg;
    private JLabel fiveDollarsReg;
    private JLabel tenDollarsReg;
    private JLabel twentyDollarsReg;


    private JPanel mainNorth;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel mainCenter;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel mainSouth;
    private JPanel panel6;
    private JPanel panel7;
    //</editor-fold>

    JFrame borderLayoutFrame = new JFrame();

    public CashierFrame() {
        setSize(300, 400);
        setTitle("Cashier");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainNorth = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        mainCenter = new JPanel();
        panel4 = new JPanel();
        mainSouth = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();

        borderLayoutFrame.setLayout(new BorderLayout());
        mainNorth.setLayout(new BorderLayout());
        mainCenter.setLayout(new BorderLayout());
        mainSouth.setLayout(new BorderLayout());

        borderLayoutFrame.add(mainNorth, BorderLayout.NORTH);
        borderLayoutFrame.add(mainCenter, BorderLayout.CENTER);
        borderLayoutFrame.add(mainSouth, BorderLayout.SOUTH);

        mainNorth.add(panel1, BorderLayout.WEST);
        mainNorth.add(panel2, BorderLayout.CENTER);
        mainNorth.add(panel3, BorderLayout.EAST);
        mainCenter.add(panel4, BorderLayout.NORTH);
        mainCenter.add(panel5, BorderLayout.WEST);
        mainCenter.add(panel6, BorderLayout.CENTER);
        mainCenter.add(panel7, BorderLayout.SOUTH);

        pennies = new JButton("Pennies");
        nickels = new JButton("Nickels");
        dimes = new JButton("Dimes");
        quarters = new JButton("Quarters");
        oneDollars = new JButton("One Dollars");
        fiveDollars = new JButton("Five Dollars");
        tenDollars = new JButton("Ten Dollars");
        twentyDollars = new JButton("Twenty Dollars");
        priceLabel = new JLabel("Price: ");
        price = new JTextField();
        clear = new JButton("Clear");
        pay = new JButton("Pay");
        register = new JLabel("Register: ");
        changeLabel = new JLabel("Change: ");
        change = new JLabel();

        penniesReg = new JLabel();
        nickelsReg = new JLabel();
        dimesReg = new JLabel();
        quartersReg = new JLabel();
        oneDollarsReg = new JLabel();
        fiveDollarsReg = new JLabel();
        tenDollarsReg = new JLabel();
        twentyDollarsReg = new JLabel();

        price.setPreferredSize(new Dimension(160, 25));

        panel1.add(pennies, BorderLayout.WEST);
        panel1.add(nickels, BorderLayout.CENTER);
        panel1.add(dimes, BorderLayout.EAST);
        panel2.add(quarters, BorderLayout.WEST);
        panel2.add(oneDollars, BorderLayout.CENTER);
        panel2.add(fiveDollars, BorderLayout.EAST);
        panel3.add(tenDollars, BorderLayout.WEST);
        panel3.add(twentyDollars, BorderLayout.CENTER);
        panel4.add(priceLabel, BorderLayout.WEST);
        panel4.add(price, BorderLayout.CENTER);
        panel4.add(clear, BorderLayout.EAST);
        panel4.add(pay, BorderLayout.EAST);
        panel5.add(register, BorderLayout.WEST);
        panel5.add(penniesReg, BorderLayout.WEST);
        panel5.add(nickelsReg, BorderLayout.CENTER);
        panel5.add(dimesReg, BorderLayout.EAST);
        panel6.add(quartersReg, BorderLayout.WEST);
        panel6.add(oneDollarsReg, BorderLayout.CENTER);
        panel6.add(fiveDollarsReg, BorderLayout.EAST);
        panel6.add(tenDollarsReg, BorderLayout.WEST);
        panel6.add(twentyDollarsReg, BorderLayout.CENTER);
        panel7.add(changeLabel);
        panel7.add(change);

        Cash cashRegister = new Cash(8, 8, 8, 8, 8, 8, 8, 8);

        penniesReg.setPreferredSize(new Dimension(110, 25));
        penniesReg.setOpaque(true);
        penniesReg.setText(String.valueOf("$" + cashRegister.getPennies()) + " in pennies");
        nickelsReg.setPreferredSize(new Dimension(110, 25));
        nickelsReg.setOpaque(true);
        nickelsReg.setText(String.valueOf("$" + cashRegister.getNickels()) + " in nickels");
        dimesReg.setPreferredSize(new Dimension(110, 25));
        dimesReg.setOpaque(true);
        dimesReg.setText(String.valueOf("$" + cashRegister.getDimes()) + " in dimes");
        quartersReg.setPreferredSize(new Dimension(110, 25));
        quartersReg.setOpaque(true);
        quartersReg.setText(String.valueOf("$" + cashRegister.getQuarters()) + " in quarters");
        oneDollarsReg.setPreferredSize(new Dimension(110, 25));
        oneDollarsReg.setOpaque(true);
        oneDollarsReg.setText(String.valueOf("$" + cashRegister.getDollars()) + " in dollars");
        fiveDollarsReg.setPreferredSize(new Dimension(150, 25));
        fiveDollarsReg.setOpaque(true);
        fiveDollarsReg.setText(String.valueOf("$" + cashRegister.getFiveDollars()) + " in five dollars");
        tenDollarsReg.setPreferredSize(new Dimension(150, 25));
        tenDollarsReg.setOpaque(true);
        tenDollarsReg.setText(String.valueOf("$" + cashRegister.getTenDollars()) + " in ten dollars");
        twentyDollarsReg.setPreferredSize(new Dimension(170, 25));
        twentyDollarsReg.setOpaque(true);
        twentyDollarsReg.setText(String.valueOf("$" + cashRegister.getTwentyDollars()) + " in twenty dollars");

        changeLabel.setPreferredSize(new Dimension(100, 25));
        changeLabel.setOpaque(true);

        Cash cashCustomerPay = new Cash();
        Cashier cashier = new Cashier(cashRegister);
        Cash cashChange = new Cash();

        pennies.addActionListener(actionEvent -> addPenniesToPay(cashCustomerPay));
        nickels.addActionListener(actionEvent -> addNickelsToPay(cashCustomerPay));
        dimes.addActionListener(actionEvent -> addDimesToPay(cashCustomerPay));
        quarters.addActionListener(actionEvent -> addQuartersToPay(cashCustomerPay));
        oneDollars.addActionListener(actionEvent -> addOneDollarsToPay(cashCustomerPay));
        fiveDollars.addActionListener(actionEvent -> addFiveDollarsToPay(cashCustomerPay));
        tenDollars.addActionListener(actionEvent -> addTenDollarsToPay(cashCustomerPay));
        twentyDollars.addActionListener(actionEvent -> addTwentyDollarsToPay(cashCustomerPay));
        pay.addActionListener(actionEvent -> {
            try {
                calculateChange(cashCustomerPay, cashier, cashRegister);
            } catch (NotEnoughChangeException e) {
                e.printStackTrace();
            }
        });
        clear.addActionListener(actionEven -> resetPay(cashCustomerPay));


        borderLayoutFrame.pack();
        borderLayoutFrame.setVisible(true);
        mainNorth.setVisible(true);
        panel1.setVisible(true);
        priceLabel.setOpaque(true);
        priceLabel.setBackground(Color.white);


    }

    public void addPenniesToPay(Cash cashCustomerPay) {
        cashCustomerPay.addPennies();
    }

    public void addNickelsToPay(Cash cashCustomerPay) {
        cashCustomerPay.addNickels();
    }

    public void addDimesToPay(Cash cashCustomerPay) {
        cashCustomerPay.addDimes();
    }

    public void addQuartersToPay(Cash cashCustomerPay) {
        cashCustomerPay.addQuarters();
    }

    public void addOneDollarsToPay(Cash cashCustomerPay) {
        cashCustomerPay.addDollars();
    }

    public void addFiveDollarsToPay(Cash cashCustomerPay) {
        cashCustomerPay.addFiveDollars();
    }

    public void addTenDollarsToPay(Cash cashCustomerPay) {
        cashCustomerPay.addTenDollars();
    }

    public void addTwentyDollarsToPay(Cash cashCustomerPay) {
        cashCustomerPay.addTwentyDollars();
    }

    public void calculateChange(Cash cashCustomerPay, Cashier cashier, Cash cashRegister) throws NotEnoughChangeException {
        try {
            double priceIt = Double.valueOf(price.getText());
            if (cashRegister.totalCash() == 0) {
                change.setText("Error: no cash in Register");
            }
            try {
                Cash cashReturn = cashier.pay(priceIt, cashCustomerPay);
                if (priceIt > cashCustomerPay.totalCash()) {
                    change.setText("You did not pay enough to cover the cost");
                } else {
                    change.setText(String.valueOf(cashReturn.totalCash()));
                    penniesReg.setText(String.valueOf("$" + cashRegister.getPennies()) + " in pennies");
                    nickelsReg.setText(String.valueOf("$" + cashRegister.getNickels()) + " in nickels");
                    dimesReg.setText(String.valueOf("$" + cashRegister.getDimes()) + " in dimes");
                    quartersReg.setText(String.valueOf("$" + cashRegister.getQuarters()) + " in quarters");
                    oneDollarsReg.setText(String.valueOf("$" + cashRegister.getDollars()) + " in dollars");
                    fiveDollarsReg.setText(String.valueOf("$" + cashRegister.getFiveDollars()) + " in five dollars");
                    tenDollarsReg.setText(String.valueOf("$" + cashRegister.getTenDollars()) + " in ten dollars");
                    twentyDollarsReg.setText(String.valueOf("$" + cashRegister.getTwentyDollars()) + " in twenty dollars");

                }
            } catch (NotEnoughChangeException ex) {
                change.setText("Not enough change in the cash register");
            }
        } catch (Exception ex) {
            change.setText("There was an error with the price");
        }

    }

    public void resetPay(Cash customerPay) {
        customerPay.setPennies(0);
        customerPay.setNickels(0);
        customerPay.setDimes(0);
        customerPay.setQuarters(0);
        customerPay.setDollars(0);
        customerPay.setFiveDollars(0);
        customerPay.setTenDollars(0);
        customerPay.setTwentyDollars(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CashierFrame();
            }
        });
    }

}
