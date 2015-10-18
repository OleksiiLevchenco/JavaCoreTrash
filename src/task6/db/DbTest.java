package task6.db;

import task5.xml.Transformer;

import java.math.BigDecimal;
import java.sql.*;


/**
 * @author Alexey Levchenko
 */
public class DbTest {
    private String DB_DRIVER = "com.mysql.jdbc.Driver";
    private String DB_CONNECTION = "jdbc:mysql://localhost:3306/study";
    private String DB_USER = "root";
    private String DB_PASSWORD = "serverPassword";
    private Connection connection;
    private Statement statement;

    public Connection getDbConnect() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
            System.err.println("Driver is loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found" + e.getMessage());
            System.exit(0);
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            System.err.println("Connection is received");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return dbConnection;
    }

    public void getDbTable() {
        String sql = "SELECT* FROM transformers WHERE output_voltage = 48;";
        try {
            connection = getDbConnect();
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            int columnCount = resultSet.getMetaData().getColumnCount();


            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getMetaData().getColumnLabel(i) + "\t ");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t \t");
                }
                System.out.println();
            }
        } catch (SQLException e){
            System.out.println("SQL request error: \n" + e);
        }
    }

    public void insertDbRecord(Transformer transformer) throws SQLException {
        String sql = "INSERT INTO transformers VALUES (?,?,?,?,?,?);";
        connection = getDbConnect();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, transformer.getId());
        preparedStatement.setInt(2, transformer.getInputVoltage());
        preparedStatement.setInt(3, transformer.getOutputVoltage());
        preparedStatement.setInt(4, transformer.getOutputCurrent());
        preparedStatement.setFloat(5, transformer.getMass());
        preparedStatement.setBigDecimal(6, transformer.getPrice());
        preparedStatement.execute();

        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException, InterruptedException {
        DbTest dbTest = new DbTest();
        dbTest.getDbTable();
        try {

            dbTest.insertDbRecord(new Transformer(17,1100,640,170,250f,new BigDecimal("280.128")));
        } catch (Exception e){
            System.out.println("\n"+e);
        }

        dbTest.getDbTable();

        if(dbTest.connection != null){
            dbTest.connection.close();
        }
    }

}

