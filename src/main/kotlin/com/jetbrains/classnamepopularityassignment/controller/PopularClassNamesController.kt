package com.jetbrains.classnamepopularityassignment.controller

import com.jetbrains.classnamepopularityassignment.service.PopularClassNamesService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Popular class names controller
 *
 * @property popularClassNamesService [PopularClassNamesService]
 */
@RestController
@RequestMapping("/popular-classnames")

class PopularClassNamesController(
    private val popularClassNamesService: PopularClassNamesService
) {
    /**
     * Get popular class names
     *
     * @return
     */
    @GetMapping("/process")
    fun getPopularClassNames(): ResponseEntity<List<Map.Entry<String?, Int>>> {
        val parsedClassList = popularClassNamesService.processClassNames()
        return ResponseEntity.ok(parsedClassList)
    }

}