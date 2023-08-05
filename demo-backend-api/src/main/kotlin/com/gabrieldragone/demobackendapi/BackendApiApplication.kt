package com.gabrieldragone.demobackendapi

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableRabbit
class BackendApiApplication

fun main(args: Array<String>) {
    println("Starting API Project")
    runApplication<BackendApiApplication>(*args)
    println("API Project's Running")
}