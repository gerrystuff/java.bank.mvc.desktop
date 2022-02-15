package components.InventoryMoneyComponent;

import controllers.BankController;
import controllers.InventoryMoneyController;
import views.InventoryMoneyView;

public class InventoryMoneyComponent {
    InventoryMoneyView inventoryMoneyView;
     InventoryMoneyController inventoryMoneyController;

    public InventoryMoneyComponent(){
        inventoryMoneyView = new InventoryMoneyView();
        this.inventoryMoneyController = new InventoryMoneyController(inventoryMoneyView);
        this.inventoryMoneyView.setController(inventoryMoneyController);

    }

    public void setMainController(BankController bankController){
        this.inventoryMoneyController.injectMainController(bankController);
    }

    public InventoryMoneyView getView(){
        return this.inventoryMoneyView;
    }
}
