package com.whoslooz.whoslooz.repositories;
import java.util.List;

import com.whoslooz.whoslooz.entities.LoozItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LoozRepository extends MongoRepository<LoozItem, String> {
    List<LoozItem> findByNameContaining(String name);

        @Query("{name:'?0'}")
        LoozItem findItemByName(String name);

        @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
        List<LoozItem> findAll(String category);

    }
