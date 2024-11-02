package com.jetbrains.classnamepopularityassignment.service

import com.jetbrains.classnamepopularityassignment.datasource.ClassNamesDatasource
import com.jetbrains.classnamepopularityassignment.datasource.github.model.GitHubResponseItem
import org.springframework.stereotype.Service

/**
 * Popular class names service
 *
 * @property datasource [ClassNamesDatasource] - generic return type based on selected datasource
 */
@Service
class PopularClassNamesService(
    private val datasource: ClassNamesDatasource<GitHubResponseItem>
) {
    /**
     * Process class names by grouping them by name and sorting them in descending order
     *
     * @return parsedClassList [List<Map.Entry<String?, Int>>]
     */
    fun processClassNames(): List<Map.Entry<String?, Int>> {
        val classList = datasource.getClassNames()
        val parsedClassList = classList
            .groupingBy { key -> key.name }
            .eachCount().entries
            .sortedByDescending { it.value }

        return parsedClassList
    }
}