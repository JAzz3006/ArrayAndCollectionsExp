import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    private String name;
    private LocalDate deadline;

    public Task(String name, LocalDate deadline) {
        this.name = name;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Что сделать: " + name + '\'' +
                ", к дате: " + deadline;
    }
}
