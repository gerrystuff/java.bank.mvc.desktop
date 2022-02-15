package controllers;

import views.ExchangeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class ExchangeController implements ActionListener {
    ExchangeView exchangeView;
    BankController bankController;

    public ExchangeController(ExchangeView exchangeView){
        this.exchangeView = exchangeView;
    }


    public void injectMainController(BankController bankController){
        this.bankController = bankController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() ==  exchangeView.transactionBtn){
            int $import =  exchangeView.getImport();


            Optional<String> exchange = bankController.exchange($import);

            bankController.setTotalMoney();

            if(!exchange.isEmpty()){
                JOptionPane.showMessageDialog(null,exchange.get(),"Error",1);
                return;
            }

//            exchangeView.

        }

    }
}
