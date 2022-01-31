package br.com.map.controller;

import br.com.map.domain.exception.ApiMapsGeoCodeAddressNotFoundException;
import br.com.map.domain.exception.ApiMapsGeoCodePathNotFoundException;
import br.com.map.dto.GeoCodeAddress;
import br.com.map.dto.GeoCodeAddressCustom;
import br.com.map.service.ApiMapsGeoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/address/")
public class ApiMapsGeoCodeController {

    @Autowired
    private ApiMapsGeoCodeService apiMapsGeoCodeService;

    public ApiMapsGeoCodeController(ApiMapsGeoCodeService apiMapsGeoCodeService) {
        this.apiMapsGeoCodeService = apiMapsGeoCodeService;
    }

    @PostMapping
    public List<GeoCodeAddressCustom> getAddress(@RequestBody GeoCodeAddress geoCodeAddress) throws ApiMapsGeoCodePathNotFoundException, ApiMapsGeoCodeAddressNotFoundException {
        return apiMapsGeoCodeService.buildAddress(geoCodeAddress);
    }

}

