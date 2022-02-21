package views;

import controllers.BankController;
import utils.Utils;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;
import java.awt.*;
import java.util.Optional;

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



        ticketPanel.add(ticketLabel,BorderLayout.NORTH);
        ticketPanel.add(distributionPanel,BorderLayout.CENTER);




        exchangePanel.add(transactionPanel,BorderLayout.NORTH);
        exchangePanel.add(ticketPanel,BorderLayout.CENTER);


    }


    public Optional<Integer> getImport(){
        String $import = transactionInput.getText();

        if(!$import.matches("[0-9]+")){
            throwError("Solo digitos");
            return Optional.empty();
        }
        return Optional.of(Integer.parseInt($import));
    }


    public void setController(BankController bankController){

        this.transactionBtn.addActionListener(bankController);
    }


    public void throwError(String error){
        JOptionPane.showMessageDialog(null, error, "Error", 1);

    }


    public void setDistribution(int[] distribution){
        // Remove all data
        this.distributionPanel.removeAll();
        distributionPanel.add(new JLabel("Denomination",SwingConstants.CENTER));
        distributionPanel.add(new JLabel("Quantity Bills",SwingConstants.CENTER));


        for (int i = 0; i < Utils.denominationList.length; i++) {
        if(distribution[i] == 0)
            continue;
            // Add denomination
            this.distributionPanel.add(new JLabel(Integer.toString(Utils.denominationList[i]), SwingConstants.CENTER));
            // Add distribution bills
            this.distributionPanel.add(new JLabel(Integer.toString(distribution[i]), SwingConstants.CENTER));
        }


//        title.setText("Inventory Money : " + totalMoney);
        revalidate();


    }

}
