package org.ck.test.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;

import com.datastax.driver.core.Session;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testCassandra() {
        Connection con = null;
        try {
            Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
            con = DriverManager.getConnection("jdbc:cassandra://localhost:9160/demodb1");

            String query = "SELECT * FROM emp ";

            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            System.out.println("My results : ");

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

    public void testDatastax() {
        Cluster cluster = Cluster.builder()
                .addContactPoint("127.0.0.1")
                .build();
        Metadata metadata = cluster.getMetadata();
        System.out.printf("Connected to cluster: %s\n",
                metadata.getClusterName());

        for ( Host host : metadata.getAllHosts() ) {
            System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n",
                    host.getDatacenter(), host.getAddress(), host.getRack());
        }

        final Session session = cluster.connect();

        assertNotNull(session);
    }
}
