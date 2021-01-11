package projekt;

public class Car {
    private int car_id;
    private String license_plate;
    private String mark;
    private String model;
    private String VIN;
    private String body_type;
    private int model_year;
    private int engine_size;
    private String fuel_type;
    private int mileage;
    private int price_id;
    private int office_id;

    public Car(int car_id, String license_plate, String mark, String model, String VIN, String body_type, int model_year, int engine_size, String fuel_type, int mileage, int price_id, int office_id) {
        this.car_id = car_id;
        this.license_plate = license_plate;
        this.mark = mark;
        this.model = model;
        this.VIN = VIN;
        this.body_type = body_type;
        this.model_year = model_year;
        this.engine_size = engine_size;
        this.fuel_type = fuel_type;
        this.mileage = mileage;
        this.price_id = price_id;
        this.office_id = office_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
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

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getBody_type() {
        return body_type;
    }

    public void setBody_type(String body_type) {
        this.body_type = body_type;
    }

    public int getModel_year() {
        return model_year;
    }

    public void setModel_year(int model_year) {
        this.model_year = model_year;
    }

    public int getEngine_size() {
        return engine_size;
    }

    public void setEngine_size(int engine_size) {
        this.engine_size = engine_size;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice_id() {
        return price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }

    public int getOffice_id() {
        return office_id;
    }

    public void setOffice_id(int office_id) {
        this.office_id = office_id;
    }
}

