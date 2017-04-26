// AePONA Group Ltd
// Head Office: Interpoint Building, 20-24 York Street,
// Belfast BT15 1AQ, Northern Ireland.
//
// All Rights Reserved.
//
// This document or any part thereof may not, without the written
// consent of AePONA Limited, be copied, reprinted or reproduced in
// any material form including but not limited to photocopying,
// transcribing, transmitting or storing it in any medium or
// translating it into any language, in any form or by any means,
// be it electronic, mechanical, xerographic, optical,
// magnetic or otherwise.
/**
 * @author mm0565
 */
package org.ck.mytests.mqtt;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ct20308
 */
public class MqttMessageData {

    private Double longitude;
    private Double latitude;
    private Double level;
    private Double radius;
    private String sensorId;
    private String label;
    private Map<String, String> sensorMetadata = new HashMap<String, String>();
    private String link;
    private String state;
    private String type;

    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(final Double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(final Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the level
     */
    public Double getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(final Double level) {
        this.level = level;
    }

    /**
     * @return the sensorId
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
     * @param sensorId the sensorId to set
     */
    public void setSensorId(final String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * @return the radius
     */
    public Double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(final Double radius) {
        this.radius = radius;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(final String label) {
        this.label = label;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(final String link) {
        this.link = link;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(final String state) {
        this.state = state;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    /**
     * @return the sensorMetadata
     */
    public Map<String, String> getSensorMetadata() {
        return sensorMetadata;
    }

    /**
     * @param sensorMetadata the sensorMetadata to set
     */
    public void setSensorMetadata(final Map<String, String> sensorMetadata) {
        this.sensorMetadata = sensorMetadata;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(final String type) {
        this.type = type;
    }
}