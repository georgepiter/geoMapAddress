package br.com.map.dto;


import br.com.map.domain.ApiMapsGeoCodeAddress;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ApiMapsGeoCodeAddressDto {

    @JsonProperty("listAddress")
    private List<ApiMapsGeoCodeAddress> addressList = new ArrayList<>();

    public ApiMapsGeoCodeAddressDto(List<ApiMapsGeoCodeAddress> addressList) {
        this.addressList = addressList;
    }

    public ApiMapsGeoCodeAddressDto() {
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
