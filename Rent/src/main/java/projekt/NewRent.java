package projekt;

public class NewRent {
    private int id;
    private String mark;
    private String model;
    private String body;
    private int year;
    private int engine;
    private int mil;
    private String city;
    private int day;

    public NewRent(int id, String mark, String model, String body, int year, int engine, int mil, String city, int day) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.body = body;
        this.year = year;
        this.engine = engine;
        this.mil = mil;
        this.city = city;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public int getMil() {
        return mil;
    }

    public void setMil(int mil) {
        this.mil = mil;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
