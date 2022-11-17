package br.com.ren.server.controller;

import br.com.ren.server.dto.DataDTO;
import br.com.ren.server.resource.ResponseResource;
import br.com.ren.server.service.DataService;
import br.com.ren.server.service.impl.DataServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataController {
    private static final Logger log = LoggerFactory.getLogger(DataController.class);

    @Autowired
    DataService dataService;

    @PostMapping("/data")
    public ResponseEntity<ResponseResource> postData(@RequestBody DataDTO data) throws Exception {
        long startTime = System.currentTimeMillis();
        log.info("postData start - for id = {} ",data.getIotAgentId());
        ResponseEntity<ResponseResource> returnValue = ResponseEntity.ok().body(dataService.postData(data));
        long endTime = System.currentTimeMillis();
        log.info("postData end - for id = {} execution time = {} ", data.getIotAgentId(), endTime - startTime);
        return returnValue;
    }
}
