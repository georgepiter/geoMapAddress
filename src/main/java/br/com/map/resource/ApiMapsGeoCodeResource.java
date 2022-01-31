package br.com.map.resource;

import br.com.map.domain.response.ApiMapsGeoCodeResponse;

import java.net.URISyntaxException;


public interface ApiMapsGeoCodeResource {

    ApiMapsGeoCodeResponse getGeoCodeApi(String key, String address) throws URISyntaxException;
}
