package controllers;

import models.BankModel;
import views.BankView;

import java.util.Optional;

public class BankController {
    BankModel bankModel;
    BankView bankView;
    InventoryMoneyController inventoryMoneyController;
    ExchangeController exchangeController;

    public BankController(BankView bankView,BankModel bankModel){
        this.bankModel = bankModel;
        this.bankView = bankView;
        this.inventoryMoneyController = new InventoryMoneyController(bankView.inventoryMoneyView);
        this.exchangeController = new ExchangeController(bankView.exchangeView);
        setControllers();
    }

    private void setControllers(){
        this.bankView.inventoryMoneyView.setController(inventoryMoneyController);
        this.bankView.exchangeView.setController(exchangeController);

        this.inventoryMoneyController.injectMainController(this);
        this.exchangeController.injectMainController(this);


    }



    public int[] getInventory(){
        return bankModel.getInventory();
    }

    public void setInventory(int[] inventory){
        this.bankModel.setInventory(inventory);
    }


    public Optional<String> exchange(int $importe){

        return bankModel.exchange($importe);
    }

    public void setTotalMoney(){
        int $totalMoney = bankModel.getTotalMoney();
        this.bankView.inventoryMoneyView.setTotalMoney($totalMoney);
    }

}
