package org.ck.osgi.importer.internal;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.ck.osgi.importer.MeetupService;

/**
 * Created by ck40283 on 7/13/15.
 */
@Component(name = "meetupClient", immediate = true)
public class MeetupClient {

    @Reference
    private MeetupService meetupService;


    public void bindMeetupService(MeetupService _service) {
        this.meetupService = _service;
    }

    public void unbindMeetupService(MeetupService _service) {
        if (this.meetupService == _service) {
            this.meetupService = null;
        }
    }

    public void display() {
        meetupService.showMessages();
    }

}
