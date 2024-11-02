package com.jetbrains.classnamepopularityassignment.datasource.github.client

import com.jetbrains.classnamepopularityassignment.datasource.github.client.config.FeignConfig
import com.jetbrains.classnamepopularityassignment.datasource.github.model.GitHubResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 * GitHub client
 */
@FeignClient("GitHubClient", url = "https://api.github.com",configuration = [FeignConfig::class])
interface GitHubClient {
    /**
     * Get class names from GitHub
     *
     * @param page [Int] - request page
     * @param perPage [Int] - amount of response items per page
     * @return [GitHubResponse]
     */
    @GetMapping("/search/code?q=extension:java&per_page={perPage}&page={page}")
    fun getClassNames(@PathVariable page: Int, @PathVariable perPage: Int): GitHubResponse

}