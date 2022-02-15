package views;

import controllers.ExchangeController;
import utils.Utils;

import javax.swing.*;
import java.awt.*;

public class ExchangeView extends JPanel {
    JPanel exchangePanel, transactionPanel, ticketPanel, distributionPanel;
    JLabel title,transactionLabel, ticketLabel;
    public JTextField transactionInput;
    public JButton transactionBtn;


    public ExchangeView(){
        setLayout(new BorderLayout());
        title = new JLabel("Exchange Transaction",SwingConstants.CENTER);

        setWidgets();

        add(title,BorderLayout.NORTH);
        add(exchangePanel,BorderLayout.CENTER);
        add(transactionBtn,BorderLayout.SOUTH);
    }

    private void setWidgets(){

        //J
        transactionPanel = new JPanel();
        transactionLabel = new JLabel("Import: ");
        transactionInput = new JTextField();
        transactionBtn = new JButton("Change");
        ticketLabel = new JLabel("Bills Distribution",SwingConstants.CENTER);

        //Exchange view
        exchangePanel = new JPanel();
        exchangePanel.setLayout(new BorderLayout());


        //Transaction component
        transactionPanel.setOpaque(true);
        transactionPanel.setBackground(Color.white);
        transactionPanel.setLayout(new GridLayout(1,2));
        transactionPanel.setBorder(BorderFactory.createEmptyBorder(15,10,10,10));

        transactionPanel.add(transactionLabel);
        transactionPanel.add(transactionInput);

        //Ticket view
        ticketPanel = new JPanel();
        ticketPanel.setLayout(new BorderLayout());
        ticketPanel.setOpaque(true);
        ticketPanel.setBackground(Color.white);

        distributionPanel = new JPanel();

        distributionPanel.setOpaque(true);
        distributionPanel.setBackground(Color.white);
        distributionPanel.setLayout(new GridLayout(0,2));

        distributionPanel.add(new JLabel("Denomination",SwingConstants.CENTER));
        distributionPanel.add(new JLabel("Quantity Bills",SwingConstants.CENTER));

        for(int i = 0; i < Utils.denominationList.length; i++) {
            JLabel p = new JLabel(Integer.toString(Utils.denominationList[i]),SwingConstants.CENTER);

            distributionPanel.add(p);
            distributionPanel.add(new JLabel(""));
        }

        ticketPanel.add(ticketLabel,BorderLayout.NORTH);
        ticketPanel.add(distributionPanel,BorderLayout.CENTER);




        exchangePanel.add(transactionPanel,BorderLayout.NORTH);
        exchangePanel.add(ticketPanel,BorderLayout.CENTER);


    }


    public int getImport(){
        int $import = 0;

        try {
          $import = Integer.parseInt(transactionInput.getText());
        }catch (Exception e){
            e.printStackTrace();
        }
        return $import;
    }


    public void setController(ExchangeController controller){

        this.transactionBtn.addActionListener(controller);
    }


    public void setDistribution(int[] distribution){
        // Remove all data
        this.distributionPanel.removeAll();

        for (int i = 0; i < Utils.denominationList.length; i++) {

            // Add denomination
            this.distributionPanel.add(new JLabel(Integer.toString(Utils.denominationList[i]), SwingConstants.CENTER));
            // Add distribution bills
            this.distributionPanel.add(new JLabel(Integer.toString(distribution[i]), SwingConstants.CENTER));
        }


//        title.setText("Inventory Money : " + totalMoney);
        revalidate();


    }

}
