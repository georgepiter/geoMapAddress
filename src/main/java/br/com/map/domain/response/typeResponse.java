package br.com.map.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class typeResponse {

    @JsonProperty("types")
    private String type;

    public typeResponse(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder type = new StringBuilder("typeResponse{");
        type.append("type='").append(this.type).append('\'');
        type.append('}');
        return type.toString();
    }
}
