package br.com.map.service;

import br.com.map.domain.exception.ApiMapsGeoCodeAddressNotFoundException;
import br.com.map.domain.exception.ApiMapsGeoCodePathNotFoundException;
import br.com.map.dto.ApiMapsGeoCodeAddress;
import br.com.map.dto.GeoCodeAddress;
import br.com.map.dto.GeoCodeAddressCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

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

        AtomicReference<String> street1 = new AtomicReference<>();
        AtomicReference<String> comparedAddress1 = new AtomicReference<>();
        AtomicReference<Double> lat1 = new AtomicReference<>();
        AtomicReference<Double> lon1 = new AtomicReference<>();
        AtomicReference<String> formattedAddress1 = new AtomicReference<>();
        AtomicReference<String> message1 = new AtomicReference<>();

        AtomicReference<String> street2 = new AtomicReference<>();
        AtomicReference<String> comparedAddress2 = new AtomicReference<>();
        AtomicReference<Double> lat2 = new AtomicReference<>();
        AtomicReference<Double> lon2 = new AtomicReference<>();
        AtomicReference<String> formattedAddress2 = new AtomicReference<>();
        AtomicReference<String> message2 = new AtomicReference<>();

        List<GeoCodeAddressCustom> geoCodeAddressCustomListDistance = new ArrayList<>();
        List<GeoCodeAddressCustom> copyList = new ArrayList<>();
        copyList.addAll(geoCodeAddressCustomList);

        for (GeoCodeAddressCustom GeoCodeAddressCustom : geoCodeAddressCustomList) {
            copyList.stream()
                    .filter(copy -> copy.getLatitude() != null && copy.getLongitude() != null &&
                            !copy.getLatitude().equals(GeoCodeAddressCustom.getLatitude()) && !copy.getLongitude()
                            .equals(GeoCodeAddressCustom.getLongitude()))
                    .forEach(copy -> {
                        street1.set(GeoCodeAddressCustom.getStreet());
                        formattedAddress1.set(GeoCodeAddressCustom.getFormattedAddress());
                        comparedAddress1.set(GeoCodeAddressCustom.getStreet());
                        message1.set(GeoCodeAddressCustom.getMessage());
                        lat1.set(GeoCodeAddressCustom.getLatitude());
                        lon1.set(GeoCodeAddressCustom.getLongitude());

                        street2.set(copy.getStreet());
                        comparedAddress2.set(copy.getStreet());
                        formattedAddress2.set(copy.getFormattedAddress());
                        message2.set(copy.getMessage());
                        lat2.set(copy.getLatitude());
                        lon2.set(copy.getLongitude());

                        geoCodeAddressCustomListDistance.addAll(calculation(street1.get(),
                                street2.get(), comparedAddress1.get(),
                                comparedAddress2.get(), formattedAddress1.get(),
                                message1.get(), formattedAddress2.get(),
                                message2.get(), lat1.get(), lat2.get(),
                                lon1.get(), lon2.get()));
                    });
        }
        return buildReturnComparator(geoCodeAddressCustomListDistance.stream().distinct().collect(Collectors.toList()));
    }

    private List<GeoCodeAddressCustom> calculation(String street1, String street2, String comparedAddress1,
                                                   String comparedAddress2, String formattedAddress1,
                                                   String message1, String formattedAddress2, String message2,
                                                   Double lat1, Double lat2, Double lon1, Double lon2) {
        List<GeoCodeAddressCustom> calculationDistanceAddress = new ArrayList<>();

        Double value1 = lat1 - lat2;
        Double value2 = lon1 - lon2;

        for (int i = 0; i < 2; i++) {
            GeoCodeAddressCustom geoCodeAddressCustom = new GeoCodeAddressCustom();
            if (i == 0) {
                geoCodeAddressCustom.setStreet(street1);
                geoCodeAddressCustom.setDistance(calculateEuclideanDistance(value1, value2));
                geoCodeAddressCustom.setComparedAddress(comparedAddress2);
                geoCodeAddressCustom.setFormattedAddress(formattedAddress1);
                geoCodeAddressCustom.setMessage(message1);
                geoCodeAddressCustom.setLatitude(lat1);
                geoCodeAddressCustom.setLongitude(lon1);
            }
            if (i == 1) {
                geoCodeAddressCustom.setStreet(street2);
                geoCodeAddressCustom.setDistance(calculateEuclideanDistance(value1, value2));
                geoCodeAddressCustom.setComparedAddress(comparedAddress1);
                geoCodeAddressCustom.setFormattedAddress(formattedAddress2);
                geoCodeAddressCustom.setMessage(message2);
                geoCodeAddressCustom.setLatitude(lat2);
                geoCodeAddressCustom.setLongitude(lon2);
            }
            calculationDistanceAddress.add(geoCodeAddressCustom);
        }
        return calculationDistanceAddress;
    }

    private double calculateEuclideanDistance(Double value1, Double value2) {
        double calculation = Math.sqrt(Math.pow(value1, 2) + Math.pow(value2, 2));
        return Math.round(calculation * 100.0);
    }

    private List<GeoCodeAddressCustom> buildReturnComparator(List<GeoCodeAddressCustom> addressCustomList) {
        List<GeoCodeAddressCustom> codeAddressCustom = new ArrayList<>();
        addressCustomList
                .stream().sorted(Comparator.comparing(GeoCodeAddressCustom::getDistance))
                .forEach(codeAddressCustom::add);
        return codeAddressCustom;
    }
}
