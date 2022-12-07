package com.minikode.webflux_demo.handler

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse
import java.util.concurrent.Executors
import java.util.stream.Stream
import kotlin.streams.toList

@Configuration
class RxHandler {



    @Bean
    fun routerExample(): RouterFunction<ServerResponse> {
        return RouterFunctions.route() //1
            .GET("/func/{maxCount}") { request ->
                val maxCount = request.pathVariable("maxCount").toLong()
                val map = mutableMapOf<String, List<Int>>()
                map["data"] = Stream.iterate(0) { i -> i.times(2) }
                    .limit(maxCount).toList()
//                val es = Executors.newFixedThreadPool(1000)
//                val future = es.submit {
//                    sleepThread(100)
//                }
//                future.get()
//                val t = CoroutineScope(Dispatchers.IO).async {
//                    println(1)
//                    sleepThread(1000)
//                    println(2)
//                }
//                println(3)
//                t.await()
                ServerResponse.ok().bodyValue(map)
            } //2
            .build() //5
    }

    suspend fun sleepThread(milliseconds: Long) {
        Thread.sleep(milliseconds)
    }

}