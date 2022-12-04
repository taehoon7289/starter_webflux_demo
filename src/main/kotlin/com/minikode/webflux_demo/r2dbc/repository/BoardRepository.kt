package com.minikode.webflux_demo.r2dbc.repository

import com.minikode.webflux_demo.r2dbc.entity.BoardEntity
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface BoardRepository : R2dbcRepository<BoardEntity, Long> {
}