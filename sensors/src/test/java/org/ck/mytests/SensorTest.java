package org.ck.mytests;

import org.ck.mytests.sensors.domain.Sensor;
import org.ck.mytests.sensors.domain.SensorRepository;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Unit test for Sensor
 */
public class SensorTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(SensorTest.class);

    @Autowired
    private SensorRepository sensorRepository;

    @Test
    public void storeSensorDataAndRetrieve() {

        Date date = new Date();
        Sensor sensor = new Sensor(UUID.randomUUID().toString(), date, "temperature", "23.2233");
        sensorRepository.save(sensor);

        Sensor data = sensorRepository.findBySensorId(sensor.getSensorId(), (new SimpleDateFormat("yyyy-MM-dd")).format(date));

//        Assert.assertTrue(it.iterator().hasNext());
//        for (Sensor data : it) {
            System.out.println(data.getSensorId());
            System.out.println(data.getSensorReading());
            System.out.println(data.getSensorEventTimestamp());
//        }

    }

}
