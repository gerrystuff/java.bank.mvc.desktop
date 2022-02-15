package models;

import utils.Utils;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;
import java.util.Arrays;
import java.util.Optional;

public class BankModel {


    private int[] inventoryMoney;

    public BankModel(){
        this.inventoryMoney = new int[Utils.denominationList.length];

        Arrays.fill(inventoryMoney,0);

    }


    public int getTotalMoney(){
        int totalMoney = 0;

        for (int i = 0; i < Utils.denominationList.length; i++) {
                // Count total money
                totalMoney += inventoryMoney[i] * Utils.denominationList[i];
            }

        return totalMoney;
    }

    public Optional<String> exchange(int $importe){
        System.out.println("entre");
        // Check if total amount is grater thant total bank money
        if($importe > getTotalMoney())
            return Optional.of("La cantidad ingresa es mayor al total de dinero");

        for (int i = 0; i < Utils.denominationList.length; i++){

            // Check if denomination is grater than the amount
            if(Utils.denominationList[i] > $importe)
                continue;


            // The inventory and amount is rested
            inventoryMoney[i] --;
            $importe -= Utils.denominationList[i];

            System.out.println($importe);
            if($importe == 0){

                for (int  k = 0; k < Utils.denominationList.length; k++) {
                    System.out.println(Utils.denominationList[k] + "\t" + inventoryMoney[k]);
                }
                return Optional.empty();
            }

            if(Utils.denominationList[i] == 1 && $importe != 0){
                i = 0;
            }
        }



        return Optional.empty();
    }



    public void setInventory(int[] inventoryMoney){
        this.inventoryMoney = inventoryMoney;
    }

    public int[] getInventory(){

        return this.inventoryMoney;

    }

}
