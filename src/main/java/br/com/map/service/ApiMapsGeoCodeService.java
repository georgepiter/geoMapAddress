package br.com.map.service;

import br.com.map.domain.exception.ApiMapsGeoCodeAddressNotFoundException;
import br.com.map.domain.exception.ApiMapsGeoCodePathNotFoundException;
import br.com.map.dto.ApiMapsGeoCodeAddress;
import br.com.map.dto.GeoCodeAddress;
import br.com.map.dto.GeoCodeAddressCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ApiMapsGeoCodeService {

    @Autowired
    private ApiMapsGeoCodeApiService apiMapsGeoCodeApiService;

    public List<GeoCodeAddressCustom> buildAddress(GeoCodeAddress geoCodeAddress) throws ApiMapsGeoCodePathNotFoundException, ApiMapsGeoCodeAddressNotFoundException {
        List<ApiMapsGeoCodeAddress> addressList = geoCodeAddress.getAddressList();
        List<GeoCodeAddressCustom> geoCodeAddressCustomList = new ArrayList<>();

        for (ApiMapsGeoCodeAddress address : addressList) {
            GeoCodeAddressCustom addressCustom = apiMapsGeoCodeApiService.getGeolocation(address);
            geoCodeAddressCustomList.add(addressCustom);
        }
        return getDistanceCalculation(geoCodeAddressCustomList);
    }

    private List<GeoCodeAddressCustom> getDistanceCalculation(List<GeoCodeAddressCustom> geoCodeAddressCustomList) {
        Double lat1 = null;
        Double lon1 = null;

        List<GeoCodeAddressCustom> geoCodeAddressCustomListDistance = new ArrayList<>();

        List<GeoCodeAddressCustom> copyList = new ArrayList<>();
        copyList.addAll(geoCodeAddressCustomList);

        for (GeoCodeAddressCustom geoCodeAddressCustom : geoCodeAddressCustomList) {
           lat1 = geoCodeAddressCustom.getLatitude();
           lon1 = geoCodeAddressCustom.getLongitude();
           calculation(lat1, lon1, copyList);
        }

        return geoCodeAddressCustomListDistance;
    }

    private void calculation(Double lat1, Double lon1, List<GeoCodeAddressCustom> copyList) {
        Double lat2 = null;
        Double lon2 = null;
        double distance;

        for (GeoCodeAddressCustom geoCodeAddressCustom : copyList) {
            lat2 = geoCodeAddressCustom.getLatitude();
            lon2 = geoCodeAddressCustom.getLongitude();
          distance = getSqrt(lat1, lon1, lat2, lon2);
        }
    }

    private double getSqrt(Double lat1, Double lon1, Double lat2, Double lon2) {
        return Math.sqrt(Math.pow(lat1 - lat2, 2) + Math.pow(lon1 - lon2, 2));
    }


}
