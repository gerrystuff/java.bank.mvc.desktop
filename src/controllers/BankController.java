package controllers;

import models.BankModel;
import views.AttentionBarView;
import views.BankView;
import views.ExchangeView;
import views.InventoryMoneyView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class BankController implements ActionListener {
    BankModel bankModel;

    ExchangeView exchangeView;
    InventoryMoneyView inventoryMoneyView;
    AttentionBarView attentionBarView;


    public BankController(BankView bankView, BankModel bankModel) {
        this.bankModel = bankModel;
        this.exchangeView = bankView.exchangeView;
        this.inventoryMoneyView = bankView.inventoryMoneyView;
        this.attentionBarView = bankView.attentionBarView;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exchangeView.transactionBtn) {

            Optional<Integer> $import = exchangeView.getImport();

            if($import.isEmpty())
                return;

            Optional<String> exchangeRes =  bankModel.exchange($import.get());

            if(!exchangeRes.isEmpty()) {
                exchangeView.throwError(exchangeRes.get());
                return;
            }

            // Actualiza el inventario
            inventoryMoneyView.updateInventory(bankModel.getInventory());

            // Actualiza la distribucion de billetes
            exchangeView.setDistribution(bankModel.getLastTransaction());

            // Actualiza la barra de atencion
            attentionBarView.updateAttentionBar(bankModel.getTransactionsCounter());


        }

        if (e.getSource() == inventoryMoneyView.addBillsBtn) {
            this.bankModel.addMoney();
            inventoryMoneyView.updateInventory(bankModel.getInventory());
            return;
        }



    }
}
