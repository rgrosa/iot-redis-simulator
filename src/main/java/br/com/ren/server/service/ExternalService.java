package br.com.ren.server.service;

import br.com.ren.server.dto.EnrichDataDTO;
import br.com.ren.server.entity.MasterEntity;

public interface ExternalService {

    MasterEntity getMasterDataFromExternalServer(Long id) throws InterruptedException;

    String sendEnrichDataForAnotherServer(EnrichDataDTO enrichDataDTO);
}
