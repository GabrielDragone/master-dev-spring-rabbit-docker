package com.gabrieldragone.demobackendworker

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableRabbit
class DemoBackendWorkerApplication

fun main(args: Array<String>) {
	println("Starting WORKER Project")
	runApplication<DemoBackendWorkerApplication>(*args)
	println("WORKER Project's Running")
}
