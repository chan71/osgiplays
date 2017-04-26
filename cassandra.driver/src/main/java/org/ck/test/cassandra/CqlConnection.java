package org.ck.test.cassandra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CqlConnection {

    public static void main(String[] args) throws Exception{

        Connection con = null;
        try {
            Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
            con = DriverManager.getConnection("jdbc:cassandra://localhost:9160/demodb1");

            String query = "SELECT * FROM emp ";

            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                System.out.print(result.getString("empid") + " ");
                System.out.print(result.getString("deptid") + " ");
                System.out.print(result.getString("first_name") + " ");
                System.out.print(result.getString("last_name") + " ");
                System.out.println();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                con = null;
            }
        }

    }
}
