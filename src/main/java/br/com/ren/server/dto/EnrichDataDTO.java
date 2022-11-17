package br.com.ren.server.dto;

import br.com.ren.server.entity.OwnerDataEntity;

import java.io.Serializable;

public class EnrichDataDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private DataDTO data;
    private OwnerDataEntity masterData;


    public EnrichDataDTO(DataDTO data, OwnerDataEntity masterData) {
        this.data = data;
        this.masterData = masterData;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public OwnerDataEntity getMasterData() {
        return masterData;
    }

    public void setMasterData(OwnerDataEntity masterData) {
        this.masterData = masterData;
    }
}
