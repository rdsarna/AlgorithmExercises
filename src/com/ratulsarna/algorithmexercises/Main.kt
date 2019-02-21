package com.ratulsarna.algorithmexercises

import com.ratulsarna.algorithmexercises.datastructures.SinglyLinkedList
import com.ratulsarna.algorithmexercises.datastructures.Stack


fun main2() {
    println("Sum of squares of 3: ${sumOfSquares(3)}")

    println("Reverse of 'abc def' is: ${reverseString("abc def")}")

    val stack = Stack<Int>().apply {
        push(1)
        push(2)
        push(3)
    }
    stutterStack(stack)
    println("Stutter stack of {1,2,3} is: $stack")

    println("isSubsequence(\"computer\", \"core\") should be false and actual is: ${isSubsequence("computer", "core")}")
    println("isSubsequence(\"computer\", \"cope\") should be true and actual is: ${isSubsequence("computer", "cope")}")
    println("isSubsequence(\"computer\", \"computer\") should be true and actual is: ${isSubsequence("computer", "computer")}")

    println("{1,1,2,3,5} should be partitionable and actual is: ${partitionable(listOf(1,1,2,3,5))}")
    println("{1,4,5,6} should not be partitionable and actual is: ${partitionable(listOf(1,4,5,6))}")
}

fun main() {
    val list = SinglyLinkedList<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
        add(5)
    }

    println("Size: ${list.size()}")
    println("$list")

    list.add(2, 11)
    println("$list")

    list.removeAt(2)
    println("$list")
}