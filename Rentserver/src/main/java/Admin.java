public class Admin {
    private int id;
    private String login;
    private String password;
    private String job;
    private String ename;

    public Admin(int id, String login, String password, String job, String ename) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.job = job;
        this.ename = ename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
