package br.com.ren.server.dto;

import br.com.ren.server.entity.MasterEntity;

import java.io.Serializable;

public class EnrichDataDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private DataDTO data;
    private MasterEntity masterData;


    public EnrichDataDTO(DataDTO data, MasterEntity masterData) {
        this.data = data;
        this.masterData = masterData;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public MasterEntity getMasterData() {
        return masterData;
    }

    public void setMasterData(MasterEntity masterData) {
        this.masterData = masterData;
    }
}
