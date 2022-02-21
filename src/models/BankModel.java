package models;

import utils.Utils;

import java.util.Arrays;
import java.util.Optional;

public class BankModel {


    private int[] inventoryMoney;
    private int[] lastTransaction;
    private int transactionsCounter;

    public BankModel() {
        this.inventoryMoney = new int[Utils.denominationList.length];
        this.lastTransaction = new int[Utils.denominationList.length];
        transactionsCounter = 0;


        Arrays.fill(inventoryMoney, 0);
        Arrays.fill(lastTransaction, 0);

    }

    public int getTransactionsCounter(){
        return this.transactionsCounter;
    }


    public int getTotalMoney() {
        int totalMoney = 0;

        for (int i = 0; i < Utils.denominationList.length; i++) {
            totalMoney += inventoryMoney[i] * Utils.denominationList[i];
        }

        return totalMoney;
    }

    private Optional<String> simulateExchange(int $importe) {

        int[] inventoryMoneyAux = inventoryMoney.clone();

        for (int i = 0; i < Utils.denominationList.length; i++) {

            // Check si la denominacion es mas grande que el importe
            if (Utils.denominationList[i] > $importe || inventoryMoneyAux[i] == 0)
                continue;

            // El inventario y la cantidad total se actualizan

            do {
                inventoryMoneyAux[i]--;

                $importe -= Utils.denominationList[i];

            } while (Utils.denominationList[i] <= $importe && inventoryMoneyAux[i] != 0);

            if ($importe == 0)
                return Optional.empty();
//
//            if (Utils.denominationList[i] == 1 && $importe != 0)
//                return Optional.of("No se cuenta con el cambio necesario para la transacción");

        }
        return Optional.of("No se cuenta con el cambio necesario para la transacción");
    }

    public Optional<String> exchange(int $importe) {

        if ($importe > getTotalMoney())
            return Optional.of("La cantidad ingresada es mayor al total de dinero");

        Optional<String> canExchange =  simulateExchange($importe);

        if(!canExchange.isEmpty())
            return canExchange;


        Arrays.fill(lastTransaction, 0);

        for (int i = 0; i < Utils.denominationList.length; i++) {

            if (Utils.denominationList[i] > $importe || inventoryMoney[i] == 0)
                continue;

            do {
                inventoryMoney[i]--;
                lastTransaction[i]++;

                $importe -= Utils.denominationList[i];

            } while (Utils.denominationList[i] <= $importe && inventoryMoney[i] != 0);


            if ($importe == 0) {
                transactionsCounter++;
                return Optional.empty();
            }

        }
          return Optional.of("No se cuenta con el cambio necesario para la transacción");
    }


    public void addMoney() {
        for(int i = 0; i < inventoryMoney.length; i++)
            inventoryMoney[i] +=  Utils.getRandomNumber(10,20);
    }

    public int[] getInventory() {

        return this.inventoryMoney;

    }

    public int[] getLastTransaction() {
        return this.lastTransaction;
    }

}
