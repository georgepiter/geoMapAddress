package br.com.map.service;

import br.com.map.domain.ApiMapsGeoCodeAddress;
import br.com.map.dto.ApiMapsGeoCodeAddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiMapsGeoCodeService {

    @Autowired
    private ApiMapsGeoCodeApiService apiMapsGeoCodeApiService;

    public ApiMapsGeoCodeAddress buildAddress(ApiMapsGeoCodeAddressDto request) {
        List<ApiMapsGeoCodeAddress> addressList = request.getAddressList();
        List<ApiMapsGeoCodeAddress> newListAddress = new ArrayList<>();
        for (ApiMapsGeoCodeAddress address : addressList) {
            apiMapsGeoCodeApiService.getGeolocation(address);
        }


        return null;
    }
}
