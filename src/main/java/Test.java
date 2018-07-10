import Main.controller.BaseDataConnect;
import Main.model.Task;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {


        Task task1 = new Task(0,"01/02/2018", "Новая задача", 0, 0);
        Task task2 = new Task(0,"01/02/2018", "Новая задача", 0, 0);
        System.out.println(task1.equals(task2));

    }
}
