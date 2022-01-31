package br.com.map.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationResponse {

    @JsonProperty("lat")
    private Double latitude;

    @JsonProperty("lng")
    private Double longitude;

    public LocationResponse(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocationResponse() {
        super();
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        final StringBuilder locationResponse = new StringBuilder("LocationResponse{");
        locationResponse.append("latitude=").append(latitude);
        locationResponse.append(", longitude=").append(longitude);
        locationResponse.append('}');
        return locationResponse.toString();
    }
}
