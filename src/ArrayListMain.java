import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListMain {
    public static final String ADD_COMM = "add";
    public static final String LIST_COMM = "list";
    public static final String DELETE_COMM = "delete";
    public static final String HELP_COMM = "help";
    public static final String QUIT_COMM = "quit";


    public static void main(String[] args) {
        while(true){
            System.out.println("Введите команду (" + HELP_COMM + " для списка команд)");
            String userInput = "";
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();
            if (userInput.equals(QUIT_COMM)){
                System.out.println("Do swidanja");
                break;
            } else if (userInput.equals(ADD_COMM)) {
                System.out.println(taskMaker());
            }





            }


        }
        public static Task taskMaker(){

            System.out.println("Введите название дела");
            String nameInp = "";
            String dateInp = "";
            Scanner scanner = new Scanner(System.in);
            nameInp = scanner.nextLine();
            System.out.println("Введите дату");
            dateInp = scanner.nextLine();

        return new Task(nameInp, LocalDate.parse(dateInp));
        }

    }


