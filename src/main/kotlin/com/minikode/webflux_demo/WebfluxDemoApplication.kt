package com.minikode.webflux_demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactor.blockhound.BlockHound

@SpringBootApplication
class WebfluxDemoApplication

fun main(args: Array<String>) {
//    BlockHound.install();
    runApplication<WebfluxDemoApplication>(*args)
}
