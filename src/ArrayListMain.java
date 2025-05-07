import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayListMain {
    public static ArrayList<Task> toDoList = new ArrayList<>();
    public static final String ADD_COMM = "add";
    public static final String LIST_COMM = "list";
    public static final String DELETE_COMM = "delete";
    public static final String HELP_COMM = "help";
    public static final String QUIT_COMM = "quit";
    public static final String EDIT_COMM = "edit";
    public static final String GOODBYE_MSG = "до свидания!";
    public static final String EMPTY_MSG = "Нет запланированных дел";
    public static final String HELP = "Список команд:\n"
            + ADD_COMM + " - добавить задачу;\n"
            + DELETE_COMM + " - удалить задачу;\n"
            + EDIT_COMM + " - редактировать здачу;\n"
            + LIST_COMM + " - вывести список дел в консоль;\n"
            + HELP_COMM + " - вывести список команд в консоль;\n"
            + QUIT_COMM + " - выйти из программы.";


    public static void main(String[] args) {
        while(true){
            System.out.println("Введите команду (" + HELP_COMM + " для списка команд)");
            String userInput = "";
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();
            if (userInput.equals(QUIT_COMM)){
                System.out.println(GOODBYE_MSG);
                break;
            } else if (userInput.equals(ADD_COMM)) {
                toDoList.add(taskMaker());
            } else if (userInput.equals(LIST_COMM)) {
                if (!toDoList.isEmpty()){
                    for (int i = 0; i < toDoList.size(); i++){
                        System.out.println(i + " - " +toDoList.get(i).toString());
                    }
                } else {
                    System.out.println(EMPTY_MSG);
                }
            } else if (userInput.equals(DELETE_COMM)) {
                taskDestroyer();
            } else if (userInput.equals(EDIT_COMM)) {
                taskModifier();
            } else if (userInput.equals(HELP_COMM)) {
                System.out.println(HELP);
            } else {
                System.out.println("Такой команды нет. help для списка команд");
            }
        }

        }
        public static Task taskMaker(){
            Task task = new Task();
            System.out.println("Введите название дела");
            String nameInp = "";
            String dateInp = "";
            Scanner scanner = new Scanner(System.in);
            nameInp = scanner.nextLine();
            task.setName(nameInp);
            while (true){
                try{
                    System.out.println("Введите дату в формате гггг-мм-дд");
                    dateInp = scanner.nextLine();
                    task.setDeadline(LocalDate.parse(dateInp));
                    break;
                }catch (DateTimeParseException dtpe){
                    System.out.println("формат гггг-мм-дд обязателен. Нарпимер 1978-06-30");
                }
            }
            System.out.println("Задача добавлена");
        return task;
        }
        public static void addTask(Task task){
            toDoList.add(task);
        }

        public static void taskDestroyer(){
            int maxTaskNumber = toDoList.size() - 1;
            Scanner scanner = new Scanner(System.in);
            int userInput = 0;
            while (true){
                System.out.println("Введите номер задачи для удаления");
                try{
                    userInput = scanner.nextInt();
                    if (userInput < 0 || userInput > maxTaskNumber){
                        System.out.println("Ошибка ввода. Введите целое неотрицательное число");
                        break;
                    }else {
                        toDoList.remove(userInput);
                        System.out.println("Задача " + userInput + " удалена");
                        break;
                    }
                }catch (InputMismatchException ime){
                    System.out.println("Ошибка ввода");
                    scanner.nextLine();
                    break;
                }
            }
        }
        public static void taskModifier(){
            int userInput = 0;
            Scanner scanner = new Scanner(System.in);
            int maxTaskNumber = toDoList.size() - 1;

            while (true){
                System.out.println("Введите номер задачи для редактирования");
                try {
                    userInput = scanner.nextInt();
                    if (userInput < 0 || userInput > maxTaskNumber){
                        System.out.println("Задачи с таким номером нет");
                        break;
                    }else {
                        System.out.println("Режим редактирования:");
                        toDoList.set(userInput, taskMaker());
                        System.out.println("задача " + userInput + " заменена");
                        break;
                    }
                }catch (InputMismatchException ime){
                    System.out.println("Ошибка ввода!");
                    scanner.nextLine();
                    break;
                }
            }
        }

    }


