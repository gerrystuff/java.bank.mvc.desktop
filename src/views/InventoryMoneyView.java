package views;

import controllers.BankController;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class InventoryMoneyView extends JPanel {
    JPanel inventoryPanel, btnsPanel;
    JLabel title;
    public JButton addBillsBtn, hideInventoryBtn;
    private int totalMoney ;
    private boolean flag;
    public boolean visibilityStatus ;

    public InventoryMoneyView(){

        setLayout(new BorderLayout());
        title = new JLabel("Inventory Total Money : " + totalMoney, SwingConstants.CENTER);
        setWidgets();

        visibilityStatus = true;

        add(title,BorderLayout.NORTH);
        add(inventoryPanel,BorderLayout.CENTER);
        add(btnsPanel,BorderLayout.SOUTH);


    }

    private void setWidgets(){
        //J
        hideInventoryBtn = new JButton("Hide");
        addBillsBtn = new JButton("Add Bills");

        // Inventory Panel
        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new GridLayout(0,2));

        inventoryPanel.setOpaque(true);
        inventoryPanel.setBackground(Color.white);

        inventoryPanel.add(new JLabel("Denomination",SwingConstants.CENTER));
        inventoryPanel.add(new JLabel("Quantity",SwingConstants.CENTER));


        //Inventory Opts Component

        btnsPanel = new JPanel();
        btnsPanel.setLayout(new GridLayout(1,2));

        btnsPanel.setOpaque(true);
        btnsPanel.setBackground(Color.white);

        btnsPanel.add(addBillsBtn);
        btnsPanel.add(hideInventoryBtn);


        int[] zeroArray = new int[Utils.denominationList.length];
        Arrays.fill(zeroArray,0);
        updateInventory(zeroArray);

    }

    public void setController(BankController bankController){

        this.hideInventoryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(visibilityStatus){
                    inventoryPanel.setVisible(false);
                    hideInventoryBtn.setText("Show");
                    visibilityStatus = false;
                }else{
                    inventoryPanel.setVisible(true);
                    hideInventoryBtn.setText("Hide");
                    visibilityStatus = true;
                }

            }
        });
        this.addBillsBtn.addActionListener(bankController);

    }


    public void updateInventory(int[] inventory){

        if(flag) {
            inventoryPanel.removeAll();
            inventoryPanel.add(new JLabel("Denomination",SwingConstants.CENTER));
            inventoryPanel.add(new JLabel("Quantity",SwingConstants.CENTER));
        }
        totalMoney = 0;

            for (int i = 0; i < Utils.denominationList.length; i++) {

//                 Add denomination
                this.inventoryPanel.add(new JLabel(Integer.toString(Utils.denominationList[i]), SwingConstants.CENTER));

                    // Count total money
                    totalMoney += inventory[i] * Utils.denominationList[i];

                    // Add inventory quantity for bill
                    this.inventoryPanel.add(new JLabel(Integer.toString(inventory[i]), SwingConstants.CENTER));

            }



            title.setText("Inventory Total Money : " + totalMoney);
            flag = true;
            revalidate();
        }




}
