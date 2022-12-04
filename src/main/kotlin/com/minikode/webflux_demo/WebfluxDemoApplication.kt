package com.minikode.webflux_demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebfluxDemoApplication

fun main(args: Array<String>) {
    runApplication<WebfluxDemoApplication>(*args)
}
