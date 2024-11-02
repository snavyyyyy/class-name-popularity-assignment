package com.jetbrains.classnamepopularityassignment.datasource.github.client.config

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.beans.factory.annotation.Value

/**
 * Feign config
 */
@Configuration
class FeignConfig {

    @Value("\${github.token}")
    private lateinit var token: String

    /**
     * Feign auth interceptor - adds a Bearer token to the GitHub request
     *
     * @return
     */
    @Bean
    fun feignAuthInterceptor(): RequestInterceptor {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            requestTemplate.header(AUTHORIZATION_HEADER, "$BEARER_PREFIX $token")
        }
    }

    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
        private const val BEARER_PREFIX = "Bearer"
    }
}
