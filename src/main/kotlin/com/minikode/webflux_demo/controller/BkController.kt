package com.minikode.webflux_demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Stream
import kotlin.streams.toList

@RestController
@RequestMapping("/bk")
class BkController {
    @GetMapping(value = ["/{maxCount}"])
    fun get(@PathVariable maxCount: Int): List<Int> {
        val stream = Stream.iterate(0) { i -> i + 1 }.limit(maxCount.toLong())
//        println("blocking time : $time")
        return stream.map { it.times(2) }.toList()
    }
}

