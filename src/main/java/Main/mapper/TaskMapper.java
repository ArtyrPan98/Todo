package Main.mapper;

import Main.model.Task;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

public interface TaskMapper {

    // Простой селект. Выводит все задачи, в выбранный день.
    @Select("select * from eventDay where day = #{day}")
    ArrayList<Task> getTaskByDay(String data);

    @Select("SELECT day, COUNT(*) as state FROM eventDay GROUP BY day")
    ArrayList<Task> getListDay();

    // Простой селект. Выводит, задачу, по id
    @Select("select * from eventDay where id = #{id}")
    Task getTaskById(int id);

    @Insert("insert into eventDay (day, label, state, priority) values (#{day},#{label}, #{state}, 0)")
    void insertTaks(Task task);

    @Update("update eventDay set day=#{day}, label=#{label}, state=#{state}, priority=#{priority} where id=#{id}")
    void updateTask(Task task); // Важно! U -> u. Не забыть. Это опечатка

    @Delete("delete from eventDay where id=#{id}")
    void deleteTask(int id);

}
