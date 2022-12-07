package com.minikode.webflux_demo.r2dbc.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(
    name = "board",
    schema = "minikode"
)
@Document(collection="list")
class BoardEntity(
    title: String,
    description: String,
) {

    @Id
    @Column("board_id")
    var boardId: Long? = null
        private set

    @Column("title")
    var title = title
        private set

    @Column("description")
    var description = description
        private set


}