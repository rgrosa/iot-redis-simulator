package br.com.ren.server.service.impl;


import br.com.ren.server.dto.DataDTO;
import br.com.ren.server.entity.EnrichDataEntity;
import br.com.ren.server.entity.OwnerDataEntity;
import br.com.ren.server.repository.DataDAO;
import br.com.ren.server.repository.EnrichDataDAO;
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
    EnrichDataDAO enrichDataDAO;

    @Autowired
    ExternalService externalService;

    @Override
    public ResponseResource postData(DataDTO data) throws InterruptedException {
        OwnerDataEntity masterData = dataDAO.get(data.getIotAgentId());
        if(masterData == null){
            log.info("No master data found in redisDB for id = {}",data.getIotAgentId());
            log.info("Master da will be retrieved from external WS");
            masterData = externalService.getMasterDataFromExternalServer(data.getIotAgentId());
            dataDAO.save(masterData);
        }
        log.info("master data = {}", masterData);
        log.info("saving enrich data in redis");
        enrichDataDAO.save(new EnrichDataEntity(data.getIotAgentId(), data, masterData));

        log.info("new enrich data = {}", enrichDataDAO.get(data.getIotAgentId()));

        return new ResponseResource(200, "OK", null);
    }
}
