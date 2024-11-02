package com.jetbrains.classnamepopularityassignment.datasource

/**
 * Class names datasource
 *
 * @param T
 */
interface ClassNamesDatasource<T> {
    /**
     * Get class names from a datasource
     *
     * @return classList [MutableList<T>] - generic response depending on a datasource
     */
    fun getClassNames(): MutableList<T>

}