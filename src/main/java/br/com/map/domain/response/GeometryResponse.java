package br.com.map.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeometryResponse {

    @JsonProperty("location")
    private LocationResponse location;

    @JsonProperty("location_type")
    private String locationType;

    @JsonProperty("viewport")
    private ViewPortResponse viewport;

    public GeometryResponse(LocationResponse location, String locationType, ViewPortResponse viewport) {
        this.location = location;
        this.locationType = locationType;
        this.viewport = viewport;
    }

    public GeometryResponse() {
        super();
    }

    public LocationResponse getLocation() {
        return location;
    }

    public void setLocation(LocationResponse location) {
        this.location = location;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public ViewPortResponse getViewport() {
        return viewport;
    }

    public void setViewport(ViewPortResponse viewport) {
        this.viewport = viewport;
    }

    @Override
    public String toString() {
        final StringBuilder GeometryResponse = new StringBuilder("GeometryResponse{");
        GeometryResponse.append("location=").append(location);
        GeometryResponse.append(", locationType='").append(locationType).append('\'');
        GeometryResponse.append(", viewport=").append(viewport);
        GeometryResponse.append('}');
        return GeometryResponse.toString();
    }
}
