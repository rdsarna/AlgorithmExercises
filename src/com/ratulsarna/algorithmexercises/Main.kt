package com.ratulsarna.algorithmexercises

import com.ratulsarna.algorithmexercises.datastructures.Stack


fun main() {
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
}