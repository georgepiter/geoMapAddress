package br.com.map.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GeoCodeAddress {

    @JsonProperty("listAddress")
    private List<ApiMapsGeoCodeAddress> addressList = new ArrayList<>();

    public GeoCodeAddress(List<ApiMapsGeoCodeAddress> addressList) {
        this.addressList = addressList;
    }

    public GeoCodeAddress() {
        super();
    }

    public List<ApiMapsGeoCodeAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<ApiMapsGeoCodeAddress> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "ApiMapsGeoCodeAddressDto{" +
                "addressList=" + addressList +
                '}';
    }
}
