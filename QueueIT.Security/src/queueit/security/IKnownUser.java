package queueit.security;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Queue-it
 * last update: 2012-10-25
 */
public interface IKnownUser {

    public UUID getQueueId();    
    public Integer getPlaceInQueue();
    public Date getTimeStamp();
    public String getCustomerId();
    public String getEventId();
    public String getOriginalUrl();
    public RedirectType getRedirectType();
}
