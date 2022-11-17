package br.com.ren.server.repository;

import br.com.ren.server.entity.OwnerDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class DataDAO {

    public static final String HASH_KEY = "data";

    @Autowired
    private RedisTemplate template;

    public OwnerDataEntity save(OwnerDataEntity data){
        template.opsForHash().put(HASH_KEY, data.getId(), data);
        return data;
    }

    public OwnerDataEntity get(Long id){
        return (OwnerDataEntity) template.opsForHash().get(HASH_KEY, id);
    }

}
