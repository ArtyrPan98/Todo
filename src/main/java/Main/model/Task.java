package Main.model;

public class Task {
private long id;
private String day;
private String label;
private int state;



    private int priority;


    public Task() {
    }

    public Task(String day, String label, int state) {
        this.day = day;
        this.label = label;
        this.state = state;
        this.priority = 0;
    }

    public Task(long id, String day, String label, int state, int priority) {
        this.id = id;
        this.day = day;
        this.label = label;
        this.state = state;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString(){
        String str = "";
        str+= "id = " + id + "\n";
        str+= "day = " + day +"\n";
        str+= "label = " + label + "\n";
        str+= "state = " + state + "\n";
        str+= "priority = " + priority + "\n";
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        Task taskObj = (Task) obj;
        if(!this.label.equals(taskObj.label)) return false;
        if(!this.day.equals(taskObj.day)) return false;
        if(this.id != taskObj.id) return false;
        if(this.priority != taskObj.priority) return false;
        if(this.state != taskObj.state) return false;
        return true;
    }
}
