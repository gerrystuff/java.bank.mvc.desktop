package components.AttentionBarComponent;

import controllers.AttentionBarController;
import controllers.BankController;
import views.AttentionBarView;

public class AttentionBarComponent {
    private AttentionBarController attentionBarController;
    public AttentionBarView attentionBarView;

    public AttentionBarComponent(){

        attentionBarView = new AttentionBarView();
        this.attentionBarController = new AttentionBarController(attentionBarView);
    }

    public AttentionBarController getAttentionBarController(){
        return this.attentionBarController;
    }

    public void setMainController(BankController bankController){
        this.attentionBarController.injectMainController(bankController);
    }

    public AttentionBarView getView(){
        return this.attentionBarView;
    }


}
