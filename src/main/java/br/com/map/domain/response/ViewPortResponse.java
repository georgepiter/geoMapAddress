package br.com.map.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViewPortResponse {

    @JsonProperty("northeast")
    private LocationResponse northeast;

    @JsonProperty("southwest")
    private LocationResponse southwest;

    public ViewPortResponse(LocationResponse northeast, LocationResponse southwest) {
        this.northeast = northeast;
        this.southwest = southwest;
    }

    public ViewPortResponse() {
        super();
    }

    public LocationResponse getNortheast() {
        return northeast;
    }

    public void setNortheast(LocationResponse northeast) {
        this.northeast = northeast;
    }

    public LocationResponse getSouthwest() {
        return southwest;
    }

    public void setSouthwest(LocationResponse southwest) {
        this.southwest = southwest;
    }

    @Override
    public String toString() {
        final StringBuilder viewPortResponse = new StringBuilder("ViewPortResponse{");
        viewPortResponse.append("northeast=").append(northeast);
        viewPortResponse.append(", southwest=").append(southwest);
        viewPortResponse.append('}');
        return viewPortResponse.toString();
    }
}
