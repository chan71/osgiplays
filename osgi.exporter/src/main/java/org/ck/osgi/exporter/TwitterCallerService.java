package org.ck.osgi.exporter;

/**
 * Created by ck40283 on 7/11/15.
 */
public class TwitterCallerService {
    private String message;

    public String tweet() {
        return message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
