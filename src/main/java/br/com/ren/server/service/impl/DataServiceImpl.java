package br.com.ren.server.service.impl;


import br.com.ren.server.dto.DataDTO;
import br.com.ren.server.dto.EnrichDataDTO;
import br.com.ren.server.entity.OwnerDataEntity;
import br.com.ren.server.repository.DataDAO;
import br.com.ren.server.resource.ResponseResource;
import br.com.ren.server.service.DataService;
import br.com.ren.server.service.ExternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DataServiceImpl implements DataService {
    private static final Logger log = LoggerFactory.getLogger(DataServiceImpl.class);

    @Autowired
    DataDAO dataDAO;

    @Autowired
    ExternalService externalService;

    @Override
    public ResponseResource postData(DataDTO data) throws InterruptedException {
        OwnerDataEntity masterData = dataDAO.get(data.getIotAgentId());
        if(masterData == null){
            log.info("No data found for id = {}",data.getIotAgentId());
            masterData = externalService.getMasterDataFromExternalServer(data.getIotAgentId());
            dataDAO.save(masterData);
        }
        log.info("master data = {}", masterData);
        return new ResponseResource(200, externalService.sendEnrichDataForAnotherServer(new EnrichDataDTO(data, masterData)), null);
    }
}
