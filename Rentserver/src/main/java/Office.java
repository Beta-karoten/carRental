public class Office {
    private int office_id;
    private String Address;
    private String phone;
    private String city;

    public Office(int office_id, String address, String phone, String city) {
        this.office_id = office_id;
        Address = address;
        this.phone = phone;
        this.city = city;
    }

    public int getOffice_id() {
        return office_id;
    }

    public void setOffice_id(int office_id) {
        this.office_id = office_id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
