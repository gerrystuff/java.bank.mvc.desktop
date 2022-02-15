package controllers;

import views.InventoryMoneyView;
import utils.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryMoneyController implements ActionListener {

    InventoryMoneyView inventoryMoneyView;
    BankController bankController;

    public InventoryMoneyController(InventoryMoneyView inventoryMoneyView){
        this.inventoryMoneyView = inventoryMoneyView;
    }

    public void refreshView(){
        this.inventoryMoneyView.updateInventory(bankController.getInventory());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == inventoryMoneyView.addBillsBtn){
            System.out.println("entre aki");
            bankController.setInventory(Utils.getRandomNumberArray());
            inventoryMoneyView.updateInventory(bankController.getInventory());
            return;
        }

    }

    public void injectMainController(BankController bankController){
        this.bankController = bankController;
        this.refreshView();

    }
}
