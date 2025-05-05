import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayMain {
    public static final int NUMBERS_RANGE = 100;

    public static void main(String[] args) {
        int arraySize = 0;
        int [] initialArray = new int[3];
        try{
            arraySize = getArraySize();
            initialArray = fillInitialArray(arraySize);
        } catch (InputMismatchException | NegativeArraySizeException e) {
            System.out.println("input missmatch !");
            arraySize = getArraySize();
            initialArray = fillInitialArray(arraySize);
        }

        int [] reverseArray = getReverseArray(initialArray);
        System.out.println(Arrays.toString(initialArray));
        System.out.println(Arrays.toString(reverseArray));

    }

    public static int getArraySize() throws NegativeArraySizeException, InputMismatchException{
        System.out.println("Введите размер массива - целое положительное число");
        return new Scanner(System.in).nextInt();
    }

    public static int[] fillInitialArray(int arraySize){
        int[] initialArray = new int[arraySize];
        for (int i = 0; i < initialArray.length; ++i){
            initialArray[i] = (int) (Math.random() * 100);
        }
        return  initialArray;
    }
    public static int[] getReverseArray(int[] initialArray){
        int[] reverseArray = new int[initialArray.length];
        int maxIndex = initialArray.length - 1;
        for (int i = 0; i < initialArray.length; ++i){
            reverseArray[i] = initialArray[maxIndex - i];
        }
        return reverseArray;
    }

}
