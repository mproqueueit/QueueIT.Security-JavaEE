package queueit.security;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class MockUrlProvider implements IKnownUserUrlProvider {
    
    private String url;
    private String queueId;
    private String placeInQueue;
    private String timeStamp;
    private String eventId;
    private String customerId;
    private String originalUrl;
    private String redirectType;

    public MockUrlProvider(
            String url, String queueId, String placeInQueue, String timeStamp, String eventId, String customerId, String originalUrl, String redirectType) {
        this.url = url;
        this.queueId = queueId;
        this.placeInQueue = placeInQueue;
        this.timeStamp = timeStamp;
        this.eventId = eventId;
        this.customerId = customerId;
        this.originalUrl = originalUrl;
        this.redirectType = redirectType;
    }
    
    public MockUrlProvider(String requestUrl, String originalUrl) {
        Map<String, String> parameters = getUrlParameters(requestUrl.toString());
        
        this.url = requestUrl;
        this.queueId = parameters.get("q");
        this.placeInQueue = parameters.get("p");
        this.timeStamp = parameters.get("ts");
        this.eventId = parameters.get("e");
        this.customerId = parameters.get("c");
        this.originalUrl = originalUrl;
        this.redirectType = parameters.get("rt");
    }
    
    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getQueueId(String queryStringPrefix) {
        return this.queueId;
    }

    @Override
    public String getPlaceInQueue(String queryStringPrefix) {
        return this.placeInQueue;
    }

    @Override
    public String getTimeStamp(String queryStringPrefix) {
        return this.timeStamp;
    }

    @Override
    public String getEventId(String queryStringPrefix) {
        return this.eventId;
    }

    @Override
    public String getCustomerId(String queryStringPrefix) {
        return this.customerId;
    }

    @Override
    public String getOriginalUrl(String queryStringPrefix) {
        return this.originalUrl;
    }

    @Override
    public String getRedirectType(String queryStringPrefix) {
        return this.redirectType;
    }
    
    private static Map<String, String> getUrlParameters(String url) {
        Map<String, String> params = new HashMap<String, String>();
        String[] urlParts = url.split("\\?");
        if (urlParts.length > 1) {
            String query = urlParts[1];
            for (String param : query.split("&")) {
                try {
                    String pair[] = param.split("=");
                    String key = URLDecoder.decode(pair[0], "UTF-8");
                    String value = "";
                    if (pair.length > 1) {
                        value = URLDecoder.decode(pair[1], "UTF-8");
                    }
                    String values = params.get(key);
                    if (values == null) {
                        params.put(key, value);
                    }
                } catch (UnsupportedEncodingException ex) {
                    return null;
                }
            }
        }
        return params;
    }
}
