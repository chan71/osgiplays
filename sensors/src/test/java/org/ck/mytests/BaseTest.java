package org.ck.mytests;

import org.ck.mytests.sensors.domain.Sensor;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.cql.CqlIdentifier;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

/**
 * Created by ck40283 on 2/1/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = CassandraConfiguration.class)
@ContextConfiguration(locations = "classpath:springContext.xml")
public abstract class BaseTest {

    @Autowired
    private CassandraAdminOperations adminTemplate;

    @Before
    public void resetKeySpace() {
        adminTemplate.dropTable(CqlIdentifier.cqlId("sensor"));
        adminTemplate.createTable(true, CqlIdentifier.cqlId("sensor"), Sensor.class, new HashMap<String, Object>());
    }
}