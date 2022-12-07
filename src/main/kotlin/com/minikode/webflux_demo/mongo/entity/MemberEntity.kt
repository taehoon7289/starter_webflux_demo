package com.minikode.webflux_demo.mongo.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.relational.core.mapping.Column
import java.util.*

@Document(collection = "member")
class MemberEntity {

    @Id
    var memberId: String? = null

    var name: String? = null

}