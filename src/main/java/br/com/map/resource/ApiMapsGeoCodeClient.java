package br.com.map.resource;

import br.com.map.domain.response.ApiMapsGeoCodeResponse;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

import java.util.concurrent.TimeUnit;

public class ApiMapsGeoCodeClient implements ApiMapsGeoCodeResource {

    private final String url;
    private final long connectTimeout;
    private final long readTimeout;

    public ApiMapsGeoCodeClient(String url, long connectTimeout, long readTimeout) {
        this.url = url;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    private ApiMapsGeoCodeResource getApi() {
        return Feign.builder()
                .options(new Request.Options(connectTimeout, TimeUnit.SECONDS, readTimeout, TimeUnit.SECONDS, true))
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .retryer(Retryer.NEVER_RETRY)
                .logLevel(Logger.Level.FULL)
                .logger(new Slf4jLogger(ApiMapsGeoCodeClient.class))
                .target(ApiMapsGeoCodeResource.class, url);
    }

    @Override
    public ApiMapsGeoCodeResponse getGeoCodeApi(String address, String key) {
        if(address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address is required");
        }
        return getApi().getGeoCodeApi(address, key);
    }


}
