package components.ExchangeComponent;

import controllers.BankController;
import controllers.ExchangeController;
import views.ExchangeView;

public class ExchangeComponent {

    ExchangeView exchangeView;
    ExchangeController exchangeController;

    public ExchangeComponent(){
        exchangeView = new ExchangeView();
        this.exchangeController = new ExchangeController(exchangeView);
        this.exchangeView.setController(exchangeController);

    }



    public void setMainController(BankController bankController){
        this.exchangeController.injectMainController(bankController);
    }
   public ExchangeView getView(){
        return this.exchangeView;
    }

}
