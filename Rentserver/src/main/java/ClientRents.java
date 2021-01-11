public class ClientRents {
    private String mark;
    private String model;
    private String datefrom;
    private String dateto;
    private int sum;

    public ClientRents(String mark, String model, String datefrom, String dateto, int sum) {
        this.mark = mark;
        this.model = model;
        this.datefrom = datefrom;
        this.dateto = dateto;
        this.sum = sum;
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

    public String getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(String datefrom) {
        this.datefrom = datefrom;
    }

    public String getDateto() {
        return dateto;
    }

    public void setDateto(String dateto) {
        this.dateto = dateto;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
