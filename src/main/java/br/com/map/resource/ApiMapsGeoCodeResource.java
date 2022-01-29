package br.com.map.resource;

import br.com.map.domain.response.ApiMapsGeoCodeResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Content-Type: application/json")
public interface ApiMapsGeoCodeResource {

    @RequestLine("GET {address}{key}")
    ApiMapsGeoCodeResponse getGeoCodeApi(@Param("address") String address, @Param("key") String key);

}
