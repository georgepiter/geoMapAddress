package br.com.map.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DecimalFormat;

public class LocationResponse {

    @JsonProperty("lat")
    private DecimalFormat latitude;

    @JsonProperty("lng")
    private DecimalFormat longitude;

    public LocationResponse(DecimalFormat latitude, DecimalFormat longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocationResponse() {
        super();
    }

    public DecimalFormat getLatitude() {
        return latitude;
    }

    public void setLatitude(DecimalFormat latitude) {
        this.latitude = latitude;
    }

    public DecimalFormat getLongitude() {
        return longitude;
    }

    public void setLongitude(DecimalFormat longitude) {
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
