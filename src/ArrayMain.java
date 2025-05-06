import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayMain {
    public static final int NUMBERS_RANGE = 100;

    public static void main(String[] args) {
        int arraySize = getArraySize();;
        int [] initialArray = fillInitialArray(arraySize);

        int [] reverseArray = getReverseArray(initialArray);
        System.out.println(Arrays.toString(initialArray));
        System.out.println(Arrays.toString(reverseArray));
    }

    public static int getArraySize() throws NegativeArraySizeException, InputMismatchException{
        Scanner scanner = new Scanner(System.in);
        int arraySize = 0;
        while (true){
            System.out.println("Введите размер массива - целое положительное число");
            try {
                arraySize = scanner.nextInt();
                if (arraySize <= 0){
                    System.out.println("Размер массива не может быть меньше нуля.");
                    continue;
                }
                break;
            }catch (InputMismatchException ime){
                System.out.println("Ошибка ввода!");
                scanner.nextLine();
            }
        }
        return arraySize;
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
