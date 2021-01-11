import org.json.JSONObject;


import java.io.*;
import java.net.Socket;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Watek extends Thread {
    private Socket socket;

    public Watek(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:base", "test", "test");
            int choice = br.read();
            switch (choice) {
                case 1: {
                    String login = br.readLine();
                    String haslo = br.readLine();
                    PreparedStatement p1 = conn.prepareStatement("SELECT * FROM CLIENT WHERE LOGIN=? AND PASSWORD=?");
                    PreparedStatement p2 = conn.prepareStatement("SELECT * FROM ADMIN WHERE LOGIN=? AND PASSWORD=?");
                    p1.setString(1, login);
                    p1.setString(2, haslo);
                    p2.setString(1, login);
                    p2.setString(2, haslo);
                    ResultSet ans1 = p1.executeQuery();
                    ResultSet ans2 = p2.executeQuery();
                    if (ans1.next()) {
                        bw.write(1);
                        bw.write(ans1.getInt(1));
                        bw.flush();
                    } else if (ans2.next()) {
                        bw.write(2);
                        bw.flush();
                    } else {
                        bw.write(0);
                        bw.flush();
                    }

                    break;
                }
                case 2: {
                    String login = br.readLine();
                    String passw = br.readLine();
                    String fname = br.readLine();
                    String lname = br.readLine();
                    String pesel = br.readLine();
                    String phone = br.readLine();
                    String drive = br.readLine();
                    PreparedStatement tmp = conn.prepareStatement("SELECT * FROM CLIENT WHERE LOGIN=?");
                    tmp.setString(1, login);
                    ResultSet ans = tmp.executeQuery();
                    if (!ans.next()) {
                        PreparedStatement p1 = conn.prepareStatement("INSERT INTO CLIENT VALUES((SELECT MAX(CLIENT_ID)+1 FROM CLIENT),?,?,?,?,?,?,?)");
                        p1.setString(1, fname);
                        p1.setString(2, lname);
                        p1.setString(3, pesel);
                        p1.setString(4, phone);
                        p1.setString(5, drive);
                        p1.setString(6, login);
                        p1.setString(7, passw);
                        p1.executeUpdate();
                        bw.write(1);
                        bw.flush();
                    } else {
                        bw.write(0);
                        bw.flush();
                    }
                    break;
                }
                case 3: {
                    Statement stmt = conn.createStatement();
                    ResultSet ans = stmt.executeQuery("SELECT * FROM CAR");
                    List<Car> cars = new ArrayList<Car>();
                    while (ans.next()) {
                        int id = ans.getInt(1);
                        String lic = ans.getString(2);
                        String mark = ans.getString(3);
                        String model = ans.getString(4);
                        String vin = ans.getString(5);
                        String body = ans.getString(6);
                        int year = ans.getInt(7);
                        int engine = ans.getInt(8);
                        String fuel = ans.getString(9);
                        int mil = ans.getInt(10);
                        int price = ans.getInt(11);
                        int office = ans.getInt(12);
                        cars.add(new Car(id, lic, mark, model, vin, body, year, engine, fuel, mil, price, office));
                    }
                    for (Car car : cars) {
                        JSONObject jsona = new JSONObject(car);
                        bw.write(jsona.toString());
                        bw.newLine();
                        bw.flush();
                    }
                    bw.flush();
                    bw.close();
                    break;
                }
                case 4: //add car
                {
                    PreparedStatement p1 = conn.prepareStatement("INSERT INTO CAR VALUES((SELECT MAX(CAR_ID)+1 FROM CAR),?,?,?,?,?,?,?,?,?,?,?)");
                    String odpt = br.readLine();
                    JSONObject car = new JSONObject(odpt);
                    p1.setString(1, car.getString("license_plate"));
                    p1.setString(2, car.getString("mark"));
                    p1.setString(3, car.getString("model"));
                    p1.setString(4, car.getString("VIN"));
                    p1.setString(5, car.getString("body_type"));
                    p1.setInt(6, car.getInt("model_year"));
                    p1.setInt(7, car.getInt("engine_size"));
                    p1.setString(8, car.getString("fuel_type"));
                    p1.setInt(9, car.getInt("mileage"));
                    p1.setInt(10, car.getInt("price_id"));
                    p1.setInt(11, car.getInt("office_id"));
                    try {
                        p1.executeUpdate();
                        bw.write(1);
                        bw.flush();
                    } catch (SQLException e) {
                        bw.write(0);
                    }

                    br.close();
                    bw.close();
                    break;
                }
                case 5: {
                    PreparedStatement p1 = conn.prepareStatement("DELETE FROM CAR WHERE CAR_ID=?");
                    p1.setInt(1, br.read());
                    p1.executeUpdate();
                    bw.write(1);
                    bw.flush();
                    br.close();
                    bw.close();
                    break;
                }
                case 6: {
                    Statement stmt = conn.createStatement();
                    ResultSet ans = stmt.executeQuery("SELECT * FROM OFFICE");
                    List<Office> offices = new ArrayList<Office>();
                    while (ans.next()) {
                        int id = ans.getInt(1);
                        String address = ans.getString(2);
                        String phone = ans.getString(3);
                        String city = ans.getString(4);
                        offices.add(new Office(id, address, phone, city));
                    }
                    for (Office office : offices) {
                        JSONObject jsona = new JSONObject(office);
                        bw.write(jsona.toString());
                        bw.newLine();
                        bw.flush();
                    }
                    bw.flush();
                    bw.close();
                    break;
                }
                case 7: {
                    PreparedStatement p1 = conn.prepareStatement("INSERT INTO OFFICE VALUES((SELECT MAX(OFFICE_ID)+1 FROM OFFICE),?,?,?)");
                    String odpt = br.readLine();
                    JSONObject office = new JSONObject(odpt);
                    p1.setString(1, office.getString("address"));
                    p1.setString(2, office.getString("phone"));
                    p1.setString(3, office.getString("city"));
                    try {
                        p1.executeUpdate();
                        bw.write(1);
                        bw.flush();
                    } catch (SQLException e) {
                        bw.write(0);
                    }

                    br.close();
                    bw.close();
                    break;
                }
                case 8: {
                    PreparedStatement p1 = conn.prepareStatement("DELETE FROM OFFICE WHERE OFFICE_ID=?");
                    p1.setInt(1, br.read());
                    p1.executeUpdate();
                    bw.write(1);
                    bw.flush();
                    br.close();
                    bw.close();
                    break;
                }
                case 9: {
                    Statement stmt = conn.createStatement();
                    ResultSet ans = stmt.executeQuery("SELECT * FROM CAR_PRICE");
                    List<Car_price> prices = new ArrayList<Car_price>();
                    while (ans.next()) {
                        int id = ans.getInt(1);
                        int day = ans.getInt(2);
                        int engine = ans.getInt(3);
                        prices.add(new Car_price(id, day, engine));
                    }
                    for (Car_price price : prices) {
                        JSONObject jsona = new JSONObject(price);
                        bw.write(jsona.toString());
                        bw.newLine();
                        bw.flush();
                    }
                    bw.flush();
                    bw.close();
                    break;
                }
                case 10: {
                    PreparedStatement p1 = conn.prepareStatement("INSERT INTO CAR_PRICE VALUES((SELECT MAX(PRICE_ID)+1 FROM CAR_PRICE),?,?)");
                    String odpt = br.readLine();
                    JSONObject price = new JSONObject(odpt);
                    p1.setInt(1, price.getInt("per_day"));
                    p1.setInt(2, price.getInt("for_engine_size"));
                    try {
                        p1.executeUpdate();
                        bw.write(1);
                        bw.flush();
                    } catch (SQLException e) {
                        bw.write(0);
                    }

                    br.close();
                    bw.close();
                    break;
                }
                case 11: {
                    PreparedStatement p1 = conn.prepareStatement("DELETE FROM CAR_PRICE WHERE PRICE_ID=?");
                    p1.setInt(1, br.read());
                    p1.executeUpdate();
                    bw.write(1);
                    bw.flush();
                    br.close();
                    bw.close();
                    break;
                }
                case 12: {
                    Statement stmt = conn.createStatement();
                    ResultSet ans = stmt.executeQuery("SELECT * FROM CLIENT");
                    List<Client> clients = new ArrayList<Client>();
                    while (ans.next()) {
                        int id = ans.getInt(1);
                        String fname = ans.getString(2);
                        String lname = ans.getString(3);
                        String pesel = ans.getString(4);
                        String phone = ans.getString(5);
                        String drive = ans.getString(6);
                        String login = ans.getString(7);
                        String pass = ans.getString(8);
                        clients.add(new Client(id, fname, lname, pesel, phone, drive, login, pass));
                    }
                    for (Client client : clients) {
                        JSONObject jsona = new JSONObject(client);
                        bw.write(jsona.toString());
                        bw.newLine();
                        bw.flush();
                    }
                    bw.flush();
                    bw.close();
                    break;
                }
                case 13: {
                    PreparedStatement p1 = conn.prepareStatement("INSERT INTO CLIENT VALUES((SELECT MAX(CLIENT_ID)+1 FROM CLIENT),?,?,?,?,?,?,?)");
                    String odpt = br.readLine();
                    JSONObject client = new JSONObject(odpt);
                    p1.setString(1, client.getString("first_name"));
                    p1.setString(2, client.getString("last_name"));
                    p1.setString(3, client.getString("pesel"));
                    p1.setString(4, client.getString("phone"));
                    p1.setString(5, client.getString("driving_license_num"));
                    p1.setString(6, client.getString("login"));
                    p1.setString(7, client.getString("password"));
                    try {
                        p1.executeUpdate();
                        bw.write(1);
                        bw.flush();
                    } catch (SQLException e) {
                        bw.write(0);
                    }

                    br.close();
                    bw.close();
                    break;
                }
                case 14: {
                    PreparedStatement p1 = conn.prepareStatement("DELETE FROM CLIENT WHERE CLIENT_ID=?");
                    p1.setInt(1, br.read());
                    p1.executeUpdate();
                    bw.write(1);
                    bw.flush();
                    br.close();
                    bw.close();
                    break;
                }
                case 15: {
                    Statement stmt = conn.createStatement();
                    ResultSet ans = stmt.executeQuery("SELECT * FROM RENT");
                    List<Rent> rents = new ArrayList<Rent>();
                    while (ans.next()) {
                        int id = ans.getInt(1);
                        Date rentdate = ans.getDate(2);
                        Date returndate = ans.getDate(3);
                        String note = ans.getString(4);
                        int clientid = ans.getInt(5);
                        int carid = ans.getInt(6);
                        int sum = ans.getInt(7);
                        DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
                        String datefrom = dateFormat.format(rentdate);
                        String dateto = dateFormat.format(returndate);
                        rents.add(new Rent(id, datefrom, dateto, note, clientid, carid, sum));
                    }
                    for (Rent rent : rents) {
                        JSONObject jsona = new JSONObject(rent);
                        bw.write(jsona.toString());
                        bw.newLine();
                        bw.flush();
                    }
                    bw.flush();
                    bw.close();
                    break;
                }
                case 16: {
                    PreparedStatement p1 = conn.prepareStatement("DELETE FROM RENT WHERE RENT_ID=?");
                    p1.setInt(1, br.read());
                    p1.executeUpdate();
                    bw.write(1);
                    bw.flush();
                    br.close();
                    bw.close();
                    break;
                }
                case 17: {
                    PreparedStatement p1 = conn.prepareStatement("SELECT M.MARK,M.MODEL,R.RENT_DATE,R.RETURN_DATE,R.SUM FROM CAR M, RENT R WHERE R.CLIENT_ID=? AND M.CAR_ID=R.CAR_ID ");
                    p1.setInt(1, br.read());
                    ResultSet ans = p1.executeQuery();
                    List<ClientRents> rents = new ArrayList<ClientRents>();
                    while (ans.next()) {
                        String mark = ans.getString(1);
                        String model = ans.getString(2);
                        Date rentdate = ans.getDate(3);
                        Date returndate = ans.getDate(4);
                        int sum = ans.getInt(5);
                        DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
                        String datefrom = dateFormat.format(rentdate);
                        String dateto = dateFormat.format(returndate);
                        rents.add(new ClientRents(mark, model, datefrom, dateto, sum));
                    }
                    for (ClientRents rent : rents) {
                        JSONObject jsona = new JSONObject(rent);
                        bw.write(jsona.toString());
                        bw.newLine();
                        bw.flush();
                    }
                    bw.flush();
                    bw.close();
                    break;
                }
                case 18: {
                    int id = br.read();
                    int odp = br.read();
                    if (odp == 1) {
                        PreparedStatement p1 = conn.prepareStatement("UPDATE CLIENT SET FIRST_NAME=? WHERE CLIENT_ID=? ");
                        p1.setString(1, br.readLine());
                        p1.setInt(2, id);
                        p1.executeUpdate();
                    } else if (odp == 2) {
                        PreparedStatement p1 = conn.prepareStatement("UPDATE CLIENT SET LAST_NAME=? WHERE CLIENT_ID=? ");
                        p1.setString(1, br.readLine());
                        p1.setInt(2, id);
                        p1.executeUpdate();
                    } else if (odp == 3) {
                        PreparedStatement p1 = conn.prepareStatement("UPDATE CLIENT SET PESEL=? WHERE CLIENT_ID=? ");
                        p1.setString(1, br.readLine());
                        p1.setInt(2, id);
                        p1.executeUpdate();
                    } else if (odp == 4) {
                        PreparedStatement p1 = conn.prepareStatement("UPDATE CLIENT SET PHONE=? WHERE CLIENT_ID=? ");
                        p1.setString(1, br.readLine());
                        p1.setInt(2, id);
                        p1.executeUpdate();
                    } else if (odp == 5) {
                        PreparedStatement p1 = conn.prepareStatement("UPDATE CLIENT SET DRIVING_LICENSE_NUM=? WHERE CLIENT_ID=? ");
                        p1.setString(1, br.readLine());
                        p1.setInt(2, id);
                        p1.executeUpdate();
                    } else if (odp == 6) {
                        PreparedStatement p1 = conn.prepareStatement("UPDATE CLIENT SET PASSWORD=? WHERE CLIENT_ID=? ");
                        p1.setString(1, br.readLine());
                        p1.setInt(2, id);
                        p1.executeUpdate();
                    }
                    bw.write(1);
                    bw.flush();
                    break;
                }
                case 19: {
                    Statement stmt = conn.createStatement();
                    ResultSet ans = stmt.executeQuery("SELECT C.CAR_ID, C.MARK,C.MODEL,C.BODY_TYPE,C.MODEL_YEAR,C.ENGINE_SIZE,C.MILEAGE,O.CITY,P.PER_DAY FROM CAR C, OFFICE O, CAR_PRICE P WHERE C.PRICE_ID=P.PRICE_ID AND C.OFFICE_ID=O.OFFICE_ID ");
                    List<NewRent> rents = new ArrayList<NewRent>();
                    while (ans.next()) {
                        int id = ans.getInt(1);
                        String mark = ans.getString(2);
                        String model = ans.getString(3);
                        String body = ans.getString(4);
                        int year = ans.getInt(5);
                        int engine = ans.getInt(6);
                        int mil = ans.getInt(7);
                        String city = ans.getString(8);
                        int day = ans.getInt(9);
                        rents.add(new NewRent(id, mark, model, body, year, engine, mil, city, day));
                    }
                    for (NewRent rent : rents) {
                        JSONObject jsona = new JSONObject(rent);
                        bw.write(jsona.toString());
                        bw.newLine();
                        bw.flush();
                    }
                    bw.flush();
                    bw.close();
                    break;
                }
                case 20: {
                    String datefrom = br.readLine();
                    String dateto = br.readLine();
                    Date rentdate = Date.valueOf(datefrom);
                    Date returndate = Date.valueOf(dateto);
                    int carid = br.read();
                    int clientid = br.read();
                    PreparedStatement preparedStmt1 = conn.prepareStatement("SELECT * FROM RENT WHERE CAR_ID=? AND RETURN_DATE BETWEEN ? AND ?");
                    preparedStmt1.setInt(1, carid);
                    preparedStmt1.setDate(2, rentdate);
                    preparedStmt1.setDate(3, returndate);
                    ResultSet ans = preparedStmt1.executeQuery();
                    if (ans.next()) {
                        bw.write(0);
                        bw.flush();
                    } else {
                        Statement stmt = conn.createStatement();
                        ResultSet tmp = stmt.executeQuery("SELECT MAX(RENT_ID)+1 FROM RENT");
                        if (tmp.next()) {
                            int rentid = tmp.getInt(1);
                            PreparedStatement p1 = conn.prepareStatement("INSERT INTO RENT VALUES(?,?,?,?,?,?,0)");
                            p1.setInt(1, rentid);
                            p1.setDate(2, rentdate);
                            p1.setDate(3, returndate);
                            String note = "brak";
                            p1.setString(4, note);
                            p1.setInt(5, clientid);
                            p1.setInt(6, carid);
                            p1.executeUpdate();
                            PreparedStatement p2 = conn.prepareStatement("UPDATE RENT SET SUM = (SELECT ROUND(((R.RETURN_DATE-R.RENT_DATE)*P.PER_DAY)) FROM RENT R, CAR_PRICE P, CAR C WHERE R.CAR_ID=C.CAR_ID AND C.PRICE_ID=P.PRICE_ID AND RENT_ID=?)WHERE RENT_ID=?");
                            p2.setInt(1, rentid);
                            p2.setInt(2, rentid);
                            p2.executeUpdate();
                        }

                        bw.write(1);
                        bw.flush();
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
