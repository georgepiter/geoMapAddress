package br.com.map.domain.exception;

public class ApiMapsGeoCodeFileIsEmptyException extends NullPointerException {

    public ApiMapsGeoCodeFileIsEmptyException(String message) {
        super(message);
    }
}
