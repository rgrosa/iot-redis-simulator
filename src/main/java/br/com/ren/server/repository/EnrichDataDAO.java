package br.com.ren.server.repository;

import br.com.ren.server.entity.EnrichDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EnrichDataDAO {

    public static final String HASH_KEY = "enrich_data";

    @Autowired
    private RedisTemplate template;

    public EnrichDataEntity save(EnrichDataEntity data){
        template.opsForHash().put(HASH_KEY, data.getIotAgentId(), data);
        return data;
    }

    public EnrichDataEntity get(Long id){
        return (EnrichDataEntity) template.opsForHash().get(HASH_KEY, id);
    }


}
