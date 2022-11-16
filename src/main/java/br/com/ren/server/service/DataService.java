package br.com.ren.server.service;

import br.com.ren.server.dto.DataDTO;
import br.com.ren.server.resource.ResponseResource;

public interface DataService {

    ResponseResource postData(DataDTO data) throws InterruptedException;

}

