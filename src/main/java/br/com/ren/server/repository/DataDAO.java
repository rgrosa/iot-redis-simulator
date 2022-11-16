package br.com.ren.server.repository;

import br.com.ren.server.entity.MasterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataDAO {

    public static final String HASH_KEY = "data";

    @Autowired
    private RedisTemplate template;

    public MasterEntity save(MasterEntity data){
        template.opsForHash().put(HASH_KEY, data.getId(), data);
        return data;
    }

    public List<MasterEntity> findAll(){
        return (List<MasterEntity>) template.opsForHash().values(HASH_KEY);
    }

    public MasterEntity get(Long id){
        return (MasterEntity) template.opsForHash().get(HASH_KEY, id);
    }

}
