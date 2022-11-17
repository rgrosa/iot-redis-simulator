package br.com.ren.server.dto;

import java.io.Serializable;
import java.util.List;

public class ExternalMasterDataDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<UserDTO> results;

    public List<UserDTO> getResults() {
        return results;
    }

    public void setResults(List<UserDTO> results) {
        this.results = results;
    }


    @Override
    public String toString() {
        return "ExternalMasterData{" +
                "results=" + results +
                '}';
    }
}
