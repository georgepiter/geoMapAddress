package br.com.map.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class AddressComponentResponse {

    @JsonProperty("long_name")
    private String longName;

    @JsonProperty("short_name")
    private String shortName;

    @JsonProperty("types")
    private List<typeResponse> types = new ArrayList<>();

    public AddressComponentResponse(String longName, String shortName, List<typeResponse> types) {
        this.longName = longName;
        this.shortName = shortName;
        this.types = types;
    }

    public AddressComponentResponse() {
    	super();
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<typeResponse> getTypes() {
        return types;
    }

    public void setTypes(List<typeResponse> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        final StringBuilder componentResponse = new StringBuilder("AddressComponentResponse{");
        componentResponse.append("longName='").append(longName).append('\'');
        componentResponse.append(", shortName='").append(shortName).append('\'');
        componentResponse.append(", types=").append(types);
        componentResponse.append('}');
        return componentResponse.toString();
    }
}
