package Main.controller;

import Main.model.Task;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BaseDataConnectTest {
    static BaseDataConnect baseDataConnect = new BaseDataConnect();
    static ArrayList<Task> tasksDay1 = new ArrayList<>();

    @BeforeClass
    static public void beforeClass(){
        tasksDay1.add(new Task(2, "01/02/2018", "Задача 1", 0, 0));
        tasksDay1.add(new Task(3, "01/02/2018", "Задача 2", 0, 0));
        tasksDay1.add(new Task(4, "01/02/2018", "Задача 3", 0, 0));
        tasksDay1.add(new Task(5, "01/02/2018", "Задача 4", 0, 0));
        // Записываем это, в БД
        baseDataConnect.insertTask(new Task("01/02/2018", "Задача 1", 0));
        baseDataConnect.insertTask(new Task("01/02/2018", "Задача 2", 0));
        baseDataConnect.insertTask(new Task("01/02/2018", "Задача 3", 0));
        baseDataConnect.insertTask(new Task("01/02/2018", "Задача 4", 0));
    }


    @Test
    public void getTaskByData() {
        ArrayList<Task> tasks = baseDataConnect.getTaskByData("01/02/2018");
        assertEquals(tasksDay1, tasks);
    }

    @Test
    public void getTaskById() {
        assertEquals( tasksDay1.get(0),baseDataConnect.getTaskById(2));
    }

    @Test
    public void updateTask() {
        baseDataConnect.updateTask(new Task(2, "01/02/2018", "Задача 1 измененна", 0, 0));
        assertEquals("Задача 1 измененна", baseDataConnect.getTaskById(2).getLabel());
        baseDataConnect.updateTask(new Task(2, "01/02/2018", "Задача 1", 0, 0));
    }

    @Test
    public void insertTask() {
        baseDataConnect.insertTask(new Task("01/02/2018","InsertTask",0));
        ArrayList<Task> tasks = baseDataConnect.getTaskByData("01/02/2018");
        assertEquals(5, tasks.size());

    }

    @Test
    public void deleteTask() {
        baseDataConnect.deleteTask(6);
        ArrayList<Task> tasks = baseDataConnect.getTaskByData("01/02/2018");
        assertEquals(tasksDay1, tasks);
    }

    @Test
    public void updateState() {
        baseDataConnect.updateState(2);
        Task task = baseDataConnect.getTaskById(2);
        assertEquals(1, task.getState());
        baseDataConnect.updateState(2);
    }

    @Test
    public void incremPriority() {
        baseDataConnect.incremPriority(2);
        assertEquals(1,baseDataConnect.getTaskById(2).getPriority());
        baseDataConnect.incremPriority(2);
        assertEquals(2,baseDataConnect.getTaskById(2).getPriority());
        baseDataConnect.incremPriority(2);
        assertEquals(3,baseDataConnect.getTaskById(2).getPriority());
        baseDataConnect.incremPriority(2);
        assertEquals(3,baseDataConnect.getTaskById(2).getPriority());
    }

    @Test
    public void decrimPriority() {
        baseDataConnect.decrimPriority(2);
        baseDataConnect.decrimPriority(2);
        baseDataConnect.decrimPriority(2);
        assertEquals(0, baseDataConnect.getTaskById(2).getPriority());
    }

    @Test
    public void getListDay() {
        ArrayList<Task> tasksDay = baseDataConnect.getListDay();
        assertEquals(5,tasksDay.get(0).getState());
    }
}