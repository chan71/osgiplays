package org.ck.osgi.importer.internal;


import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.ck.osgi.exporter.FacebookCaller;
import org.ck.osgi.exporter.TwitterCallerService;
import org.ck.osgi.importer.MeetupService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.osgi.context.BundleContextAware;


/**
 * Created by ck40283 on 7/11/15.
 */
public class MeetupServiceImpl implements MeetupService/*, BundleContextAware*/  {

    private static final Logger logger = LoggerFactory.getLogger(MeetupServiceImpl.class);

    private FacebookCaller facebookCaller;

    @Autowired
    private TwitterCallerService twitterCallerService;

    @Autowired
    private BundleContext bundleContext;

    public void showMessages() {
        this.setFacebookCaller();
        logger.info("Profile info ftrom facebook service : {}", facebookCaller != null ? facebookCaller.getProfile() : "Facebook service NOT found");
        logger.info("Message from twitter service : {}", twitterCallerService != null ? twitterCallerService.tweet() : "Twitter Service NOT found");
    }

    public TwitterCallerService getTwitterCallerService() {
        return twitterCallerService;
    }

    public void setTwitterCallerService(TwitterCallerService twitterCallerService) {
        this.twitterCallerService = twitterCallerService;
    }

    public synchronized void bindFacebookCaller(FacebookCaller _service) {
        logger.info("Setting FacebookCaller service");
        this.facebookCaller = _service;
        logger.info("Profile info from facebook service : {}", facebookCaller != null ? facebookCaller.getProfile() : "Facebook service NOT found");
    }

    public synchronized void unbindFacebookCaller(FacebookCaller service) {
        logger.info("Unsetting FacebookCaller service");
        if (this.facebookCaller == service) {
            this.facebookCaller = null;
        }
    }

    private void setFacebookCaller() {
        ServiceReference serviceReference = bundleContext.getServiceReference(FacebookCaller.class.getName());
        this.facebookCaller = (FacebookCaller) bundleContext.getService(serviceReference);
    }

    /**
     * Set the {@link org.osgi.framework.BundleContext} that this bean runs in. Normally this can be used to initialize
     * an object.
     *
     * @param bundleContext the <code>BundleContext</code> object to be used by this object
     */
/*    @Override
    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }*/
}
