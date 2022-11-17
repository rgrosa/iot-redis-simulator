package br.com.ren.server.entity;

import br.com.ren.server.dto.DataDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("enrich_data")
public class EnrichDataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //i know, i should not use this as a ID
    @Id
    private Long iotAgentId;
    private DataDTO data;
    private OwnerDataEntity masterData;

    public EnrichDataEntity(Long iotAgentId, DataDTO data, OwnerDataEntity masterData) {
        this.iotAgentId = iotAgentId;
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

    public Long getIotAgentId() {
        return iotAgentId;
    }

    public void setIotAgentId(Long iotAgentId) {
        this.iotAgentId = iotAgentId;
    }

    @Override
    public String toString() {
        return "EnrichDataEntity{" +
                "iotAgentId=" + iotAgentId +
                ", data=" + data +
                ", masterData=" + masterData +
                '}';
    }
}


