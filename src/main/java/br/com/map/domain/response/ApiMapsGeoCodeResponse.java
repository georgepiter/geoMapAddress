package br.com.map.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ApiMapsGeoCodeResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("results")
    private List<ResultResponse> results = new ArrayList<>();

    public ApiMapsGeoCodeResponse(String status, List<ResultResponse> results) {
        this.status = status;
        this.results = results;
    }

    public ApiMapsGeoCodeResponse() {
        super();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultResponse> getResults() {
        return results;
    }

    public void setResults(List<ResultResponse> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        final StringBuilder ApiMapsGeoCodeResponse = new StringBuilder("ApiMapsGeoCodeResponse{");
        ApiMapsGeoCodeResponse.append("status='").append(status).append('\'');
        ApiMapsGeoCodeResponse.append(", results=").append(results);
        ApiMapsGeoCodeResponse.append('}');
        return ApiMapsGeoCodeResponse.toString();
    }
}
