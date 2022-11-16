package br.com.ren.server.dto;

import java.io.Serializable;

public class DataDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long iotAgentId;
    private LocationDTO iotAgentLocation;
    private Boolean isIotOn;

    public Long getIotAgentId() {
        return iotAgentId;
    }

    public void setIotAgentId(Long iotAgentId) {
        this.iotAgentId = iotAgentId;
    }

    public LocationDTO getIotAgentLocation() {
        return iotAgentLocation;
    }

    public void setIotAgentLocation(LocationDTO iotAgentLocation) {
        this.iotAgentLocation = iotAgentLocation;
    }

    public Boolean getIotOn() {
        return isIotOn;
    }

    public void setIotOn(Boolean iotOn) {
        isIotOn = iotOn;
    }

    @Override
    public String toString() {
        return "DataDTO{" +
                "iotAgentId=" + iotAgentId +
                ", iotAgentLocation=" + iotAgentLocation +
                ", isIotOn=" + isIotOn +
                '}';
    }
}
