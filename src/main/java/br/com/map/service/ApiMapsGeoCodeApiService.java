package br.com.map.service;

import br.com.map.domain.ApiMapsGeoCodeAddress;
import br.com.map.domain.exception.ApiMapsGeoCodePathNotFoundException;
import br.com.map.domain.response.ApiMapsGeoCodeResponse;
import br.com.map.resource.ApiMapsGeoCodeClient;
import br.com.map.utils.ApiMapsGeoCodeConstants;
import org.springframework.stereotype.Service;

@Service
public class ApiMapsGeoCodeApiService {

    public ApiMapsGeoCodeResponse getGeolocation(ApiMapsGeoCodeAddress address) throws ApiMapsGeoCodePathNotFoundException {
        String key = ApiMapsGeoCodeAuthentication.getCredential().getProperty(ApiMapsGeoCodeConstants.PROP_KEY);
        ApiMapsGeoCodeAddress request = new ApiMapsGeoCodeAddress();
        request.setStreet(address.getStreet());
        request.setNumber(address.getNumber());
        request.setZipCode(address.getZipCode());
        ApiMapsGeoCodeResponse geoCodeResponse = getClient().getGeoCodeApi(buildStringAddress(request), key);

        return null;

    }

    private String buildStringAddress (ApiMapsGeoCodeAddress request) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(request.getStreet()).append("+")
                .append(request.getNumber()).append("+")
                .append(request.getZipCode())
                .toString();
    }

    public ApiMapsGeoCodeClient getClient() throws ApiMapsGeoCodePathNotFoundException {
        return new ApiMapsGeoCodeClient(
                ApiMapsGeoCodeAuthentication.getCredential().getProperty(ApiMapsGeoCodeConstants.PROP_URL),
                ApiMapsGeoCodeConstants.CONNECT_TIME_OUT, ApiMapsGeoCodeConstants.READ_TIME_OUT
        );
    }


}
