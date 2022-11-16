package br.com.ren.server.service.impl;


import br.com.ren.server.dto.EnrichDataDTO;
import br.com.ren.server.entity.MasterEntity;
import br.com.ren.server.service.ExternalService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class ExternalServiceImpl implements ExternalService {


    @Override
    public MasterEntity getMasterDataFromExternalServer(Long id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(new Random().nextInt(1-3) + 3);
        MasterEntity masterEntity = new MasterEntity();
        masterEntity.setId(id);
        masterEntity.setMarkName("X123X");
        masterEntity.setName("The joe doe company");
        masterEntity.setOwnerName("Joe Doe");

        return masterEntity;
    }

    @Override
    public String sendEnrichDataForAnotherServer(EnrichDataDTO enrichDataDTO) {
        return "Success - id = " + enrichDataDTO.getData().getIotAgentId();
    }
}
