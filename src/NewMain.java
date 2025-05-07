import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class NewMain {
    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        Task t1 = new Task("one", LocalDate.of(2025,05,07));
        Task t2 = new Task("two", LocalDate.of(2025, 05, 12));
        taskList.add(t1);
        taskList.add(t2);

        ArrayList<String>strings = new ArrayList<>();
        strings.add("one string");
       // strings.add("two string");
        //strings.add("three string");


        try {
            File file = new File("data/test.txt");
            if (file.createNewFile()){
                System.out.println("file was created");
            }else {
                System.out.println("file exists");
            }
            Files.write(Paths.get("data/test.txt"), strings);
        } catch (IOException e) {
            System.out.println("Error!");;
        }

    }
}
