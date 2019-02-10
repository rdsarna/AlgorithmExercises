package com.ratulsarna.algorithmexercises.datastructures

class Stack<T> {

    private val list = mutableListOf<T>()
    private var size = 0

    fun push(item: T) {
        list.add(item)
    }

    fun pop(): T? {
        return if (list.isNotEmpty()) list.removeAt(list.size - 1)
        else null
    }

    fun peek(): T? {
        return if (list.isNotEmpty()) list[list.size - 1] else null
    }

    fun size(): Int {
        return list.size
    }

    fun isEmpty(): Boolean {
        return list.size == 0
    }

    override fun toString(): String {
        if (list.isEmpty()) return ""

        var str = "{"
        list.forEach { str += "$it, " }
        str = "${str.substring(0..str.length-3)}}"
        return str
    }
}