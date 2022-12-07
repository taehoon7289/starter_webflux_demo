package com.minikode.webflux_demo.mongo.repository

import com.minikode.webflux_demo.mongo.entity.MemberEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface MemberRepository : ReactiveMongoRepository<MemberEntity, String> {
}