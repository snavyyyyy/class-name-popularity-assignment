package com.jetbrains.classnamepopularityassignment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ClassNamePopularityAssignmentApplication

fun main(args: Array<String>) {
    runApplication<ClassNamePopularityAssignmentApplication>(*args)
}
