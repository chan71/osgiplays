package org.ck.mytests.sensors.domain;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

/**
 * Created by ck40283 on 2/1/15.
 */
public interface SensorRepository extends CassandraRepository<Sensor> {

    @Query("select * from sensor where sensor_id = ?0 and date = ?1")
    Sensor findBySensorId(String sensorId, String date);
}
