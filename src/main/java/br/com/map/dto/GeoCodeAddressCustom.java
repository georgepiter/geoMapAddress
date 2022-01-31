package br.com.map.dto;

public class GeoCodeAddressCustom {

    private String formattedAddress;
    private Double latitude;
    private Double longitude;
    private String message;
    private String street;
    private Double distance;

    public GeoCodeAddressCustom(String formattedAddress, Double latitude, Double longitude) {
        this.formattedAddress = formattedAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public GeoCodeAddressCustom() {

    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        final StringBuilder adressCustom = new StringBuilder("GeoCodeAddressCustom{");
        adressCustom.append("formattedAddress='").append(formattedAddress).append('\'');
        adressCustom.append(", latitude=").append(latitude);
        adressCustom.append(", longitude=").append(longitude);
        adressCustom.append(", message=").append(message);
        adressCustom.append(", distance=").append(distance);
        adressCustom.append('}');
        return adressCustom.toString();
    }
}
