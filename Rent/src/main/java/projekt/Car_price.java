package projekt;

public class Car_price {
    private int price_id;
    private int per_day;
    private int for_engine_size;

    public Car_price(int price_id, int per_day, int for_engine_size) {
        this.price_id = price_id;
        this.per_day = per_day;
        this.for_engine_size = for_engine_size;
    }

    public int getPrice_id() {
        return price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }

    public int getPer_day() {
        return per_day;
    }

    public void setPer_day(int per_day) {
        this.per_day = per_day;
    }

    public int getFor_engine_size() {
        return for_engine_size;
    }

    public void setFor_engine_size(int for_engine_size) {
        this.for_engine_size = for_engine_size;
    }
}

