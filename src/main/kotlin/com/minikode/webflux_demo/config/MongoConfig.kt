package com.minikode.webflux_demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableMongoAuditing  //요거랑!
@EnableReactiveMongoRepositories(basePackages = ["com.minikode.webflux_demo.mongo.repository"])  //요거!
class MongoConfig {

}