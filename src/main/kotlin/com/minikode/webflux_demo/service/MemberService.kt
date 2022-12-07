package com.minikode.webflux_demo.service

import com.minikode.webflux_demo.mongo.entity.MemberEntity
import com.minikode.webflux_demo.mongo.repository.MemberRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class MemberService(
    private val memberRepository: MemberRepository,
) {

    fun saveMember(): Mono<MemberEntity> {
        val memberEntity = MemberEntity()
        memberEntity.memberId = UUID.randomUUID().toString()
        memberEntity.name = "이름은 minikode"
        return memberRepository.save(memberEntity)
    }

    fun findMembers(): Flux<MemberEntity> {
        return memberRepository.findAll()
    }

}