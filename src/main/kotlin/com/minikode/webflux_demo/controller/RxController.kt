package com.minikode.webflux_demo.controller

import com.minikode.webflux_demo.r2dbc.entity.BoardEntity
import com.minikode.webflux_demo.service.BoardService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
import java.util.stream.Stream

@RestController
@RequestMapping("/rx")
class RxController(
    private val boardService: BoardService,
) {
    @GetMapping(value = ["/{maxCount}"])
    fun get(@PathVariable maxCount: Int): Flux<Int> {
        val stream =
            Stream.iterate(0) { i -> i.times(2) }.limit(maxCount.toLong())
//        println("reative time : $time")
//        Thread.sleep(1000)
        return Flux.fromStream(stream)
    }

    @PostMapping("/")
    fun save(): ResponseEntity<Mono<BoardEntity>> {
        return ResponseEntity.ok(boardService.saveBoard())
    }

    @GetMapping("/")
    fun find(): ResponseEntity<Flux<BoardEntity>> {
        return ResponseEntity.ok(boardService.findBoards())
    }
}

