package Main.controller;

import Main.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class GreetingController {
    BaseDataConnect baseDataConnect = new BaseDataConnect();

    @GetMapping("/greeting")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/listDay")
    public String listDay() {
        return "listDay";
    }



    @RequestMapping(value = "/getTask/{day}/{month}/{age}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Task> test(@PathVariable("day") String day,
                                @PathVariable("month") String month,
                                @PathVariable("age") String age) {
        return baseDataConnect.getTaskByData(day+"/"+month+"/"+age);
    }// Работает

    @RequestMapping(value = "/getTaskById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Task test(@PathVariable("id") int id) {
        return baseDataConnect.getTaskById(id);
    }// Работает

    @PostMapping(value = "/add")
    public String add(@ModelAttribute("task") Task task){
        baseDataConnect.insertTask(task);
        return "/greeting";
    }// Работает

    @PostMapping(value = "/update")
    public String update( @ModelAttribute("id") int id){
        baseDataConnect.updateState(id);
        return "/greeting";
    }

    @PostMapping(value = "/increm")
    public String taskPriorityIncrem( @ModelAttribute("id") int id){
        baseDataConnect.incremPriority(id);
        return "/greeting";
    }
    @PostMapping(value = "/decrim")
    public String taskPriorityDecrim( @ModelAttribute("id") int id){
        baseDataConnect.decrimPriority(id);
        return "/greeting";
    }

    @RequestMapping(value = "/getListDay", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Task> getListDay() {
        return baseDataConnect.getListDay();
    }

    @PostMapping(value = "/delete")
    public String delete( @ModelAttribute("id") int id){
        baseDataConnect.deleteTask(id);
        return "/greeting";
    }




}
