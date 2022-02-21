package views;

import controllers.BankController;

import javax.swing.*;
import java.awt.*;

public class BankView extends JFrame {



    public  AttentionBarView attentionBarView;
    public  ExchangeView exchangeView;
    public  InventoryMoneyView inventoryMoneyView;

    public BankView(){
        super("Exchange Bank");

        displayLayout();
    }

    private void displayLayout(){
        setSize(600,350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,3));


        this.attentionBarView = new AttentionBarView();
        this.exchangeView = new ExchangeView();
        this.inventoryMoneyView = new InventoryMoneyView();

        add(attentionBarView);
        add(exchangeView);
        add(inventoryMoneyView);


        setVisible(true);
    }


    public void setController(BankController bankController){

        this.inventoryMoneyView.setController(bankController);
        this.exchangeView.setController(bankController);

    }






}
