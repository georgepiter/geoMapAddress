package br.com.map.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlusCodeResponse {

    @JsonProperty("compound_code")
    private String compoundCode;

    @JsonProperty("global_code")
    private String globalCode;

    public PlusCodeResponse(String compoundCode, String globalCode) {
        this.compoundCode = compoundCode;
        this.globalCode = globalCode;
    }

    public PlusCodeResponse() {
        super();
    }

    public String getCompoundCode() {
        return compoundCode;
    }

    public void setCompoundCode(String compoundCode) {
        this.compoundCode = compoundCode;
    }

    public String getGlobalCode() {
        return globalCode;
    }

    public void setGlobalCode(String globalCode) {
        this.globalCode = globalCode;
    }

    @Override
    public String toString() {
        final StringBuilder plusCodeResponse = new StringBuilder("PlusCodeResponse{");
        plusCodeResponse.append("compoundCode='").append(compoundCode).append('\'');
        plusCodeResponse.append(", globalCode='").append(globalCode).append('\'');
        plusCodeResponse.append('}');
        return plusCodeResponse.toString();
    }
}
