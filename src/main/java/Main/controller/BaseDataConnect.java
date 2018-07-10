package Main.controller;

import Main.mapper.TaskMapper;
import Main.model.Task;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class BaseDataConnect {
    private SqlSessionFactory sqlSessionFactory;
    private TaskMapper tas;
    private Reader reader = null;

    public BaseDataConnect() {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml"); //Читаем файл с настройками подключения и настройками MyBatis
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            tas = sqlSessionFactory.openSession().getMapper(TaskMapper.class); //Создаем маппер, из которого и будем вызывать методы getSubscriberById и getSubscribers

        } catch (IOException e) {
            System.out.println("Ошибка IO");
            e.printStackTrace();
        }

    } // Конструктор доступа к базе данных

    public ArrayList<Task> getTaskByData(String data){
        ArrayList<Task> listTask = tas.getTaskByDay(data);
        return listTask;
    }

    public Task getTaskById(int id){
        Task task = tas.getTaskById(id);
        return task;
    }

    public void updateTask(Task newTask){
        tas.updateTask(newTask);
    }

    public void insertTask(Task newTask){
        tas.insertTaks(newTask);
    }

    public void deleteTask(int id){
        tas.deleteTask(id);
    }

    public void updateState(int id){
        Task task = getTaskById(id);
        if(task.getState()==0){ task.setState(1); }
        else if(task.getState()==1){ task.setState(0); }
        tas.updateTask(task);
    }

    public void incremPriority(int id){
        Task task = getTaskById(id);
        if(task.getPriority()<3){
            task.setPriority(task.getPriority()+1);
        }
        tas.updateTask(task);
    }

    public void decrimPriority(int id){
        Task task = getTaskById(id);
        if(task.getPriority()>0){
            task.setPriority(task.getPriority()-1);
        }
        tas.updateTask(task);
    }

    public ArrayList<Task> getListDay(){
        ArrayList<Task> tasks = tas.getListDay();
        return tasks;
    }
}
