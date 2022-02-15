import controllers.BankController;
import models.BankModel;
import views.BankView;

public class app {
    public static void main(String[] args) {

        BankView bankView = new BankView();
        BankModel bankModel = new BankModel();
        new BankController(bankView,bankModel);

    }
}
