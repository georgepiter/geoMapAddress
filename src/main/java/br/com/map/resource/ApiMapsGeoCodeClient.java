package br.com.map.resource;

import br.com.map.domain.response.ApiMapsGeoCodeResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class ApiMapsGeoCodeClient implements ApiMapsGeoCodeResource {

    private final String url;

    RestTemplate restTemplate = new RestTemplate();


    public ApiMapsGeoCodeClient(String url) {
        this.url = url;
    }

    @Override
    public ApiMapsGeoCodeResponse getGeoCodeApi(String key, String address) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(url)
                .queryParam("address", address)
                .queryParam("key", key);
        return restTemplate
                .exchange(builder.toUriString(),
                        HttpMethod.GET,
                        entity,
                        ApiMapsGeoCodeResponse.class)
                .getBody();

    }
}
