package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDBTesting {
	private static String hostName = "localhost"; //127.0.0.1
    private static String password = "123123";
    private static String usename = "phatntt";
    private static String database = "dbWebStudent";

    /**
     *
     * get connection to database
     *
     * @return Connection to database if connect success
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getDatabaseConnection() {

            Connection conn = null;

        try {

                        Class.forName("net.sourceforge.jtds.jdbc.Driver");

                        String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + database + ";CharacterSet=UTF-8";

                        conn = DriverManager.getConnection(connectionURL, usename, password);

                        System.out.println("Connected!");

        } catch (ClassNotFoundException e) {

                        // TODO Auto-generated catch block

                        e.printStackTrace();

                } catch (SQLException e) {

                        // TODO Auto-generated catch block

                        e.printStackTrace();

                }
        return conn;

    }



public static void main(String[] args) {

	ConnectDBTesting abc = new ConnectDBTesting();

        abc.getDatabaseConnection();

}
}
