package utils;

public class Utils {
    public static final int denominationList[] = { 1000,500,200,100,50,20,10,5,2,1};

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static int firstDigit(int x) {
        while (x > 9) {
            x /= 10;
        }
        return x;
    }

    public static int[] getRandomNumberArray(){
        int [] arrayAux = new int[denominationList.length];

        for(int i = 0; i < arrayAux.length; i++){
            arrayAux[i] = getRandomNumber(1,6);
        }
        return arrayAux;
    }
}
