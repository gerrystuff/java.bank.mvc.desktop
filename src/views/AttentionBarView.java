package views;

import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttentionBarView extends JPanel {


    public JPanel attentionBarPanel, btnsPanel;
    public JButton hideButton,showButton;
    private JLabel title;
    private int hundredCounter;



    public AttentionBarView(){
        setLayout(new BorderLayout());
        hundredCounter = 0;
        title = new JLabel("Attention Bar",SwingConstants.CENTER);

        setWidgets();
        displayLayout();

        add(title,BorderLayout.NORTH);
        add(attentionBarPanel,BorderLayout.CENTER);
        add(btnsPanel,BorderLayout.SOUTH);

    }

    private void setWidgets(){

        // Attention Bar View
        attentionBarPanel = new JPanel();
        attentionBarPanel.setLayout(new GridLayout(0,2));
        attentionBarPanel.setBorder(BorderFactory.createEmptyBorder(50,30,50,30));
        attentionBarPanel.setOpaque(true);
        attentionBarPanel.setBackground(Color.white);


        // Attention Bar Options show / hide component
        btnsPanel = new JPanel();
        hideButton = new JButton("Hide");
        showButton = new JButton("Show");
        btnsPanel.setLayout(new GridLayout(1,2));

    }

    public void updateAttentionBar(int counter) {

        attentionBarPanel.removeAll();

        if (!Utils.isHundred(counter)) {
            if (hundredCounter == 0) {
                JLabel hundreds = new JLabel("10", SwingConstants.CENTER);
                JLabel quantity = new JLabel(Integer.toString(counter), SwingConstants.CENTER);

                hundreds.setVerticalAlignment(JLabel.BOTTOM);
                quantity.setVerticalAlignment(JLabel.BOTTOM);
                attentionBarPanel.add(hundreds);
                attentionBarPanel.add(quantity);
            } else {
                //  up down
                for (int i = hundredCounter; i >= 0; i--) {
                    JLabel hundreds = new JLabel((i + 1) + "0", SwingConstants.CENTER);
                    JPanel tenRectangle = new JPanel();

                    tenRectangle.setBackground(new Color(35, 168, 75));
                    tenRectangle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));


                    // single digits 1,2,3..
                    if (i == hundredCounter) {
                        JLabel quantity = new JLabel(Integer.toString(Utils.lastDigit(counter)), SwingConstants.CENTER);
                        attentionBarPanel.add(hundreds);
                        attentionBarPanel.add(quantity);


                    } else {
                        attentionBarPanel.add(hundreds);
                        attentionBarPanel.add(tenRectangle);
                    }


                }
            }


        } else {


            hundredCounter++;
            int firstDigit = Utils.firstDigit(counter);
            // Fill of Attention Bar View
            for (int i = firstDigit; i > 0; i--) {
                JLabel label = new JLabel(i + "0", SwingConstants.CENTER);

                JPanel tenRectangle = new JPanel();
                tenRectangle.setBackground(new Color(35, 168, 75));
                tenRectangle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));

                attentionBarPanel.add(label);
                attentionBarPanel.add(tenRectangle);
            }

            revalidate();
        }
    }

    private void displayLayout(){

        // Fill of Attention Bar Options


        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attentionBarPanel.setVisible(true);
            }
        });

        hideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attentionBarPanel.setVisible(false);
            }
        });



        btnsPanel.add(showButton);
        btnsPanel.add(hideButton);



    }


}
