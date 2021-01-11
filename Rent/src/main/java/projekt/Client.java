package projekt;

public class Client {
    private int client_id;
    private String first_name;
    private String last_name;
    private String pesel;
    private String phone;
    private String driving_license_num;
    private String login;
    private String password;

    public Client(int client_id, String first_name, String last_name, String pesel, String phone, String driving_license_num, String login, String password) {
        this.client_id = client_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.pesel = pesel;
        this.phone = phone;
        this.driving_license_num = driving_license_num;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDriving_license_num() {
        return driving_license_num;
    }

    public void setDriving_license_num(String driving_license_num) {
        this.driving_license_num = driving_license_num;
    }
}

