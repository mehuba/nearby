package com.mehuba.nearby.dao.mongo;

import com.mehuba.nearby.model.Colleague;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by zhaoyibin on 17:24 13/02/2018
 */
public interface ColleagueRepository extends MongoRepository<Colleague, String> {
    List<Colleague> findByName(String name);
}
