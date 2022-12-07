package com.minikode.webflux_demo.controller

import com.minikode.webflux_demo.mongo.entity.MemberEntity
import com.minikode.webflux_demo.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/mg")
class MongoController(
    private val memberService: MemberService,
) {
    @PostMapping("/")
    fun save(): ResponseEntity<Mono<MemberEntity>> {
        return ResponseEntity.ok(memberService.saveMember())
    }

    @GetMapping("/")
    fun find(): ResponseEntity<Flux<MemberEntity>> {
        return ResponseEntity.ok(memberService.findMembers())
    }
}

