package br.com.map.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ResultResponse {

    @JsonProperty("address_components")
    private List<AddressComponentResponse> addressComponents = new ArrayList<>();

    @JsonProperty("formatted_address")
    private String formattedAddress;

    @JsonProperty("geometry")
    private GeometryResponse geometry;

    @JsonProperty("place_id")
    private String placeId;

    @JsonProperty("plus_code")
    private PlusCodeResponse plusCode;

    @JsonProperty("types")
    private List<typeResponse> types = new ArrayList<>();

    public ResultResponse(List<AddressComponentResponse> addressComponents, String formattedAddress, GeometryResponse geometry, String placeId, PlusCodeResponse plusCode, List<typeResponse> types) {
        this.addressComponents = addressComponents;
        this.formattedAddress = formattedAddress;
        this.geometry = geometry;
        this.placeId = placeId;
        this.plusCode = plusCode;
        this.types = types;
    }

    public ResultResponse() {
        super();
    }

    public List<AddressComponentResponse> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(List<AddressComponentResponse> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public GeometryResponse getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryResponse geometry) {
        this.geometry = geometry;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public PlusCodeResponse getPlusCode() {
        return plusCode;
    }

    public void setPlusCode(PlusCodeResponse plusCode) {
        this.plusCode = plusCode;
    }

    public List<typeResponse> getTypes() {
        return types;
    }

    public void setTypes(List<typeResponse> types) {
        this.types = types;
    }

}
