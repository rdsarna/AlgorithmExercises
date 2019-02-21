package com.ratulsarna.algorithmexercises.datastructures

interface MyList<T> {

    fun add(item: T)
    fun add(index: Int, item: T)
    fun removeAt(index: Int)
    fun get(index: Int): T
    fun size(): Int
}