package com.minikode.webflux_demo.service

import com.minikode.webflux_demo.r2dbc.entity.BoardEntity
import com.minikode.webflux_demo.r2dbc.repository.BoardRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class BoardService(
    private val boardRepository: BoardRepository,
) {

    fun saveBoard(): Mono<BoardEntity> {
        val boardEntity = BoardEntity(
            title = "제목1",
            description = "설명11"
        )
        return boardRepository.save(boardEntity)
    }

    fun findBoards(): Flux<BoardEntity> {
        return boardRepository.findAll()
    }
}