import java.sql.Date;

public class Rent {
    private int rent_id;
    private String rent_date;
    private String return_date;
    private String note;
    private int client_id;
    private int car_id;
    private int sum;

    public Rent(int rent_id, String rent_date, String return_date, String note, int client_id, int car_id, int sum) {
        this.rent_id = rent_id;
        this.rent_date = rent_date;
        this.return_date = return_date;
        this.note = note;
        this.client_id = client_id;
        this.car_id = car_id;
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getRent_id() {
        return rent_id;
    }

    public void setRent_id(int rent_id) {
        this.rent_id = rent_id;
    }

    public String getRent_date() {
        return rent_date;
    }

    public void setRent_date(String rent_date) {
        this.rent_date = rent_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }
}

