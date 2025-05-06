import java.util.Arrays;
import java.util.Scanner;

public class HospitalMain {
    public static final float MIN_TEMPERATURE = 32f;
    public static final float MAX_TEMPERATURE = 40f;
    public static final float MAX_OK_TEMP = 36.9f;
    public static final float MIN_OK_TEMP = 36.2f;

    public static void main(String[] args) {
        float[] temperatures = getPatientsTemps(getPatientsNumber());
        getReport(temperatures);

    }

    public static void getReport(float[] initTemps){
        System.out.println(tempsToString(initTemps));
        System.out.println("Из них здоровых: " + healthyPatientsCount(initTemps) + " чел.");
        System.out.println("Средняя температура составляет " + getMeanTemp(initTemps));

    }
    public static float[] getPatientsTemps(int patientsNumber){
        float[] initTemps = new float[patientsNumber];
        for (int i = 0; i < initTemps.length; ++i){
            initTemps[i] = (float) (MIN_TEMPERATURE + Math.random() * (MAX_TEMPERATURE - MIN_TEMPERATURE));
        }
        return initTemps;
    }
    public static float getMeanTemp(float[] initTemps){
        float sumTemp = 0f;
        for (int i = 0; i < initTemps.length; ++i){
            sumTemp = sumTemp + initTemps[i];
        }
        return sumTemp / initTemps.length;
    }
    public static int healthyPatientsCount(float[] initTemps){
        int healthyCount = 0;
        for (int i = 0; i < initTemps.length; ++i){
            if (initTemps[i] >= MIN_OK_TEMP && initTemps[i] <= MAX_OK_TEMP){
                healthyCount++;
            }
        }
        return healthyCount;
    }
    public static String tempsToString(float[] initTemps){
        String temps = "Перечень замеров температур:\n";
        int firstNumper = 1;
        for (int i = 0; i < initTemps.length; ++i){
            temps = temps + (i + firstNumper) + "-й пациент - " + String.format("%.1f",initTemps[i]) + "\n";
        }
        return temps;
    }

    public static int getPatientsNumber(){
        int patientsNumber = 0;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Введите количество пациентов");
            try{
                patientsNumber = scanner.nextInt();
                if (patientsNumber <= 0){
                    System.out.println("Колическтво пациентов не может быть меньше нуля");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Ошибка ввода!");
                scanner.nextLine();
            }
        }
        return patientsNumber;
    }

}
