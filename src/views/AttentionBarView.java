package views;

import controllers.AttentionBarController;
import utils.Utils;

import javax.swing.*;
import java.awt.*;

public class AttentionBarView extends JPanel {

    public int counter = 0;

    JPanel attentionBarView, attentionBarOptsComponent;
    JButton hideButton,showButton;
    JLabel title;


    public AttentionBarView(){
        setLayout(new BorderLayout());

        title = new JLabel("Attention Bar",SwingConstants.CENTER);

        setWidgets();
        fillWidgets();

        add(title,BorderLayout.NORTH);
        add(attentionBarView,BorderLayout.CENTER);
        add(attentionBarOptsComponent,BorderLayout.SOUTH);

    }

    private void setWidgets(){

        // Attention Bar View
        attentionBarView = new JPanel();
        attentionBarView.setLayout(new GridLayout(0,2));
        attentionBarView.setBorder(BorderFactory.createEmptyBorder(50,30,50,30));
        attentionBarView.setOpaque(true);
        attentionBarView.setBackground(Color.white);


        // Attention Bar Options show / hide component
        attentionBarOptsComponent = new JPanel();
        hideButton = new JButton("Hide");
        showButton = new JButton("Show");
        attentionBarOptsComponent.setLayout(new GridLayout(1,2));

    }

    private void fillWidgets(){
        // Tens of Total Transactions
        int tens = Utils.firstDigit(counter);

        // Fill of Attention Bar View
        for(int i = 0; i < tens; i++){
            JLabel label = new JLabel(Integer.toString(i+1), SwingConstants.CENTER);

            JPanel tenRectangle = new JPanel();
            tenRectangle.setBackground(new Color(35,168,75));
            tenRectangle.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.white));

            attentionBarView.add(label);
            attentionBarView.add(tenRectangle);

        }

        // Fill of Attention Bar Options
        attentionBarOptsComponent.add(showButton);
        attentionBarOptsComponent.add(hideButton);



    }

    public void setController(AttentionBarController attentionBarController){
        showButton.addActionListener(attentionBarController);
        hideButton.addActionListener(attentionBarController);

    }

}
