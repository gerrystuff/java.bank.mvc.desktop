package views;

import controllers.InventoryMoneyController;
import utils.Utils;

import javax.swing.*;
import java.awt.*;

public class InventoryMoneyView extends JPanel {
    JPanel inventoryPanel, btnsPanel;
    JLabel title;
    public JButton addBillsBtn, hideInventoryBtn;
    private int totalMoney ;
    private boolean flag;

    public InventoryMoneyView(){

        setLayout(new BorderLayout());
        title = new JLabel("Inventory Money : " + totalMoney, SwingConstants.CENTER);
        flag = false;
        setWidgets();

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

    }

    public void setController(InventoryMoneyController inventoryMoneyController){
        this.addBillsBtn.addActionListener(inventoryMoneyController);

    }

    public void setTotalMoney(int $totalMoney){
        this.title.setText(Integer.toString($totalMoney));
    }

    public void updateInventory(int[] inventory){

        if(flag)
            inventoryPanel.removeAll();

        totalMoney = 0;

            for (int i = 0; i < Utils.denominationList.length; i++) {

//                 Add denomination
                this.inventoryPanel.add(new JLabel(Integer.toString(Utils.denominationList[i]), SwingConstants.CENTER));

                    // Count total money
                    totalMoney += inventory[i] * Utils.denominationList[i];

                    // Add inventory quantity for bill
                    this.inventoryPanel.add(new JLabel(Integer.toString(inventory[i]), SwingConstants.CENTER));
            }


            title.setText("Inventory Money : " + totalMoney);
            flag = true;
            revalidate();
        }




}
