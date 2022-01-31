package br.com.map.domain.exception;

public class ApiMapsGeoCodeAddressNotFoundException extends RuntimeException {

    public ApiMapsGeoCodeAddressNotFoundException(String message) {
        super(message);
    }
}
