package com.medasoft.config;

import com.mongodb.MongoURI;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by isurud on 3/8/14.
 */
public class SpringMongoConfig {

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception{
        MongoURI mongoClientURI = new MongoURI("mongodb://isuru:test123#@oceanic.mongohq.com:10054/meda");
       return  new SimpleMongoDbFactory(mongoClientURI);

    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception{

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return  mongoTemplate;

    }
}
