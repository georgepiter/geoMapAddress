package br.com.map.controller;

import br.com.map.dto.ApiMapsGeoCodeAddressDto;
import br.com.map.service.ApiMapsGeoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/address/")
public class ApiMapsGeoCodeController {

    @Autowired
    private ApiMapsGeoCodeService apiMapsGeoCodeService;



    public ApiMapsGeoCodeController(ApiMapsGeoCodeService apiMapsGeoCodeService) {
        this.apiMapsGeoCodeService = apiMapsGeoCodeService;
    }

    @PostMapping
    public ResponseEntity<ApiMapsGeoCodeAddressDto> getAddress(@RequestBody ApiMapsGeoCodeAddressDto address) {

        apiMapsGeoCodeService.buildAddress(address);

        return null;
    }



}

