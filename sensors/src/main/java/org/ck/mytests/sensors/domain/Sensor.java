package org.ck.mytests.sensors.domain;

//import org.joda.time.DateTime;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ck40283 on 2/1/15.
 */
@Table(value = "sensor")
public class Sensor {

    @PrimaryKeyColumn(name = "sensor_id", type = PrimaryKeyType.PARTITIONED, ordinal = 1)
    private String sensorId;

    @PrimaryKeyColumn(name = "date", type = PrimaryKeyType.PARTITIONED, ordinal = 2)
    private String date;

    @PrimaryKeyColumn(name = "sensor_event_time", type = PrimaryKeyType.CLUSTERED, ordinal = 3)
    private Date sensorEventTimestamp;

    @Column(value = "sensor_reading")
    private String sensorReading;

    @Column(value = "sensor_type")
    private String sensorType;

    public Sensor() {
    }

    /* note the wired assuming from spring data that constructor argument names should match property names */
    public Sensor(final String sensorId, final Date date, final String sensorType, final String sensorReading) {
        this.sensorId = sensorId;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.date = dateFormat.format(date);
        this.sensorEventTimestamp = date;
        this.sensorType = sensorType;
        this.sensorReading = sensorReading;
    }

    public String getSensorId() {
        return sensorId;
    }

    public String getDate() {
        return date;
    }

    public Date getSensorEventTimestamp() {
        return sensorEventTimestamp;
    }

    public String getSensorReading() {
        return sensorReading;
    }

    public String getSensorType() {
        return sensorType;
    }

    @Override
    public String toString() {
        return "Sensor{" + "sensorId=" + sensorId + ", type=" + sensorType + ", timestamp=" + sensorEventTimestamp + ", reading=" + sensorReading + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Sensor sensor = (Sensor) o;

        if (date != null ? !date.equals(sensor.date) : sensor.date != null) {
            return false;
        }
        if (sensorEventTimestamp != null ? !sensorEventTimestamp.equals(sensor.sensorEventTimestamp) :
                sensor.sensorEventTimestamp != null) {
            return false;
        }
        if (sensorId != null ? !sensorId.equals(sensor.sensorId) : sensor.sensorId != null) {
            return false;
        }
        if (sensorReading != null ? !sensorReading.equals(sensor.sensorReading) : sensor.sensorReading != null) {
            return false;
        }
        if (sensorType != null ? !sensorType.equals(sensor.sensorType) : sensor.sensorType != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = sensorId != null ? sensorId.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (sensorEventTimestamp != null ? sensorEventTimestamp.hashCode() : 0);
        result = 31 * result + (sensorReading != null ? sensorReading.hashCode() : 0);
        result = 31 * result + (sensorType != null ? sensorType.hashCode() : 0);
        return result;
    }
}
