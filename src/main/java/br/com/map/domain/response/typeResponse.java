package br.com.map.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class typeResponse {

    @JsonProperty("types")
    private List<String> type = new ArrayList<>();

    public typeResponse(List<String> type) {
        this.type = type;
    }

    public typeResponse() {
        super();
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "typeResponse{" + "type=" + type +
                '}';
    }
}
