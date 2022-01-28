package br.com.map.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiMapsGeoCodeAddress {

    @JsonProperty("street")
    private String street;

    @JsonProperty("number")
    private String number;

    @JsonProperty("zipCode")
    private String zipCode;

    public ApiMapsGeoCodeAddress(String street, String number, String zipCode) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
    }

    public ApiMapsGeoCodeAddress(){
        super();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        final StringBuilder address = new StringBuilder("ApiMapsGeoCodeAddress{");
        address.append("street='").append(street).append('\'');
        address.append(", number='").append(number).append('\'');
        address.append(", zipCode='").append(zipCode).append('\'');
        address.append('}');
        return address.toString();
    }
}
