package controllers;

import views.AttentionBarView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttentionBarController implements ActionListener {

    AttentionBarView attentionBarView;
    private BankController bankController;

    public AttentionBarController(AttentionBarView attentionBarView){
        this.attentionBarView = attentionBarView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void injectMainController(BankController bankController){
        this.bankController = bankController;
    }

}
