package org.ck.osgi.exporter.internal;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.ck.osgi.exporter.FacebookCaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ck40283 on 7/11/15.
 */
@Component(name = "facebookCaller", immediate = true)
@Service(FacebookCaller.class)
public class FacebookCallerService implements FacebookCaller {

    private static final Logger logger = LoggerFactory.getLogger(FacebookCallerService.class);

    private String profileName = "ck's profile";

    public String getProfile() {
        return profileName;
    }

    @Activate
    protected void start() {
        logger.info("Inside FacebookCallerService");
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
