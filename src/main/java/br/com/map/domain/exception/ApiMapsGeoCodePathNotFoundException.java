package br.com.map.domain.exception;

import java.io.IOException;

public class ApiMapsGeoCodePathNotFoundException extends IOException {

    public ApiMapsGeoCodePathNotFoundException(String message) {
        super(message);
    }
}
