package br.com.map.service;

import br.com.map.domain.exception.ApiMapsGeoCodeAddressNotFoundException;
import br.com.map.domain.exception.ApiMapsGeoCodePathNotFoundException;
import br.com.map.domain.response.ApiMapsGeoCodeResponse;
import br.com.map.domain.response.ResultResponse;
import br.com.map.dto.ApiMapsGeoCodeAddress;
import br.com.map.dto.GeoCodeAddressCustom;
import br.com.map.resource.ApiMapsGeoCodeClient;
import br.com.map.utils.ApiMapsGeoCodeConstants;
import org.springframework.stereotype.Service;

@Service
public class ApiMapsGeoCodeApiService {

    public GeoCodeAddressCustom getGeolocation(ApiMapsGeoCodeAddress address) throws ApiMapsGeoCodePathNotFoundException {

        String key = ApiMapsGeoCodeAuthentication.getCredential().getProperty(ApiMapsGeoCodeConstants.PROP_KEY);
        try {
            ApiMapsGeoCodeResponse geoCodeApiResponse = getClient().getGeoCodeApi(key, buildStringAddress(address));
            return buildAddressCustom(geoCodeApiResponse, address);
        } catch (ApiMapsGeoCodeAddressNotFoundException e) {
            throw new ApiMapsGeoCodeAddressNotFoundException("Address not found in google API callback" );
        }
    }

    private GeoCodeAddressCustom buildAddressCustom(ApiMapsGeoCodeResponse apiMapsGeoCodeResponse,
                                                    ApiMapsGeoCodeAddress address) {
        GeoCodeAddressCustom newGeoCodeAddressCustom = new GeoCodeAddressCustom();

        if (apiMapsGeoCodeResponse.getResults().isEmpty()) {
            throw new ApiMapsGeoCodeAddressNotFoundException("Address not found in google API callback");
        } else {
            for (ResultResponse resultResponse : apiMapsGeoCodeResponse.getResults()) {
                newGeoCodeAddressCustom.setFormattedAddress(resultResponse.getFormattedAddress());
                newGeoCodeAddressCustom.setLatitude(resultResponse.getGeometry().getLocation().getLatitude());
                newGeoCodeAddressCustom.setLongitude(resultResponse.getGeometry().getLocation().getLongitude());
                newGeoCodeAddressCustom.setMessage("Address found successfully in google API callback");
                newGeoCodeAddressCustom.setStreet(address.getStreet());
            }
        }
        return newGeoCodeAddressCustom;
    }

    private String buildStringAddress(ApiMapsGeoCodeAddress address) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(address.getStreet()).append("-")
                .append(address.getNumber()).append("-")
                .append(address.getZipCode()).toString();
    }

    public ApiMapsGeoCodeClient getClient() throws ApiMapsGeoCodePathNotFoundException {
        return new ApiMapsGeoCodeClient(
                ApiMapsGeoCodeAuthentication.getCredential().getProperty(ApiMapsGeoCodeConstants.PROP_URL));
    }
}
