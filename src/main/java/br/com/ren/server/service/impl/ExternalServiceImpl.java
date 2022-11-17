package br.com.ren.server.service.impl;


import br.com.ren.server.dto.ExternalMasterDataDTO;
import br.com.ren.server.entity.OwnerDataEntity;
import br.com.ren.server.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ExternalServiceImpl implements ExternalService {


    @Autowired
    RestTemplate restTemplate;

    @Override
    public OwnerDataEntity getMasterDataFromExternalServer(Long id) throws InterruptedException {
        OwnerDataEntity ownerDataEntity = new OwnerDataEntity();
        HttpHeaders requestHeaders = new HttpHeaders();
        ResponseEntity<ExternalMasterDataDTO> response;
        try {
            requestHeaders.setContentType(MediaType.APPLICATION_JSON);
            UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl("https://randomuser.me/api/?seed="+ id);

            HttpEntity<?> requestEntity = new HttpEntity<>(null, requestHeaders);
            response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, requestEntity, ExternalMasterDataDTO.class);
        } catch (
                HttpClientErrorException ex) {
            throw new HttpClientErrorException(ex.getStatusCode(), ex.getMessage());
        }
        ExternalMasterDataDTO externalMasterDataDTO = response.getBody();
        ownerDataEntity.setId(id);
        ownerDataEntity.setEmail(externalMasterDataDTO.getResults().get(0).getEmail());
        ownerDataEntity.setName(externalMasterDataDTO.getResults().get(0).getName().getFirst());
        ownerDataEntity.setPhone(externalMasterDataDTO.getResults().get(0).getPhone());

        return ownerDataEntity;
    }

}
