import controllers.BankController;
import models.BankModel;
import views.BankView;

public class App {
    public static void main(String[] args) {

        BankView bankView = new BankView();
        BankModel bankModel = new BankModel();
        BankController bankController = new BankController(bankView,bankModel);

        bankView.setController(bankController);



    }
}
