package com.jetbrains.classnamepopularityassignment.datasource.github

import com.jetbrains.classnamepopularityassignment.datasource.ClassNamesDatasource
import com.jetbrains.classnamepopularityassignment.datasource.github.client.GitHubClient
import com.jetbrains.classnamepopularityassignment.datasource.github.model.GitHubResponseItem
import org.springframework.stereotype.Component

/**
 * GitHub datasource
 *
 * @property gitHubClient [GitHubClient]
 */
@Component
class GitHubDatasource(
    private val gitHubClient: GitHubClient
) : ClassNamesDatasource<GitHubResponseItem> {
    override fun getClassNames(): MutableList<GitHubResponseItem> {
        val classList = mutableListOf<GitHubResponseItem>()
        var page = 1
        var response = gitHubClient.getClassNames(page, PAGE_SIZE)
        while (response.items.isNotEmpty() && page <= PAGE_LIMIT) {
            classList.addAll(response.items)
            page++
            response = gitHubClient.getClassNames(page, PAGE_SIZE)
        }
        return classList
    }

    companion object {
        private const val PAGE_LIMIT = 5
        private const val PAGE_SIZE = 100
    }
}