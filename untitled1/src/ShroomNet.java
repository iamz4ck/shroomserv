import java.sql.*;
import java.util.ArrayList;

public class ShroomNet {

    String host = "jdbc:mysql://localhost:3306/tmpRH?serverTimezone=UTC",
            user = "root",
            pass = "pass123";

    Display display;

    Connection connection = null;
    Statement statement;

    public ArrayList fullTableValues;

    public ShroomNet() {

        createMYSQLConnection();
        try {
            checkFullTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        display = new Display(this);
    }

    public void createMYSQLConnection() {
        try {
            connection = DriverManager.getConnection(host, user, pass);
        } catch (SQLException throwables) {
            System.out.println("Failed.");
            throwables.printStackTrace();
        }
    }

    public void checkFullTable() throws SQLException {
        fullTableValues = new ArrayList();
        statement = connection.createStatement();
        String sqlToExexecute = "SELECT * FROM currentReadings;";
        ResultSet resultSet = statement.executeQuery(sqlToExexecute);
        System.out.println("check full table..");
        while(resultSet.next()) {
            String sensorName = resultSet.getString("sensor");
            String rh = resultSet.getString("rh");
            float temp = (resultSet.getFloat("temp") * 9 / 5 + 32);

            String result = "sensor: " + sensorName + " rh: " + rh + " temp: " + temp;

            fullTableValues.add(result);

            //System.out.println("next()" + " Status: " + resultSet.getString("status") + ", RH: " +
            //        resultSet.getInt("rh") + "%" + " Temp: " + (resultSet.getFloat("temp") * 9 / 5 + 32) + "f");

        }

    }
}
