package com.ratulsarna.algorithmexercises

import com.ratulsarna.algorithmexercises.datastructures.Stack
import com.sun.org.apache.xpath.internal.operations.Bool

/*
Write a recursive function named sumOfSquares that takes in an integer n returns the sum of squares
from 1 to n inclusive. For example, sumOfSquares(3) should return 14 (because 1
2 + 2
2 + 3
2 = 14). You
can assume n ≥ 1.
 */
fun sumOfSquares(n : Int): Int {
    if (n == 1) return 1

    return (n * n) + sumOfSquares(n-1)
}

/*
Write a recursive function reverse that takes in a string s and returns a string with the same
characters in reverse order. For example, reverse("Hi, you!") returns "!uoy ,iH". You shouldn't
modify the original string.
 */
fun reverseString(str: String): String {
    return reverseStringHelper(str, "")
}

fun reverseStringHelper(str: String, newStr: String): String {
    if (str.isEmpty()) return newStr

    return reverseStringHelper(str.substring(0 until str.length-1), newStr + str[str.length-1])
}

/*
Write a recursive function named stutterStack that takes in a reference to a stack of integers and
replaces each integer with two copies of that integer. For example, if a stack s stores {1, 2, 3}, then
stutterStack(s) changes it to {1, 1, 2, 2, 3, 3}
 */
fun stutterStack(stack: Stack<Int>) {
    if (stack.isEmpty()) return

    val popped = stack.pop()
    stutterStack(stack)
    if (popped != null) {
        stack.push(popped)
        stack.push(popped)
    }
}

/*
Write a recursive function named isSubsequence that takes two strings and returns true if the
second string is a subsequence of the rst string. A string is a subsequence of another if it contains the
same letters in the same order, but not necessarily consecutively. You can assume both strings are all
lowercase characters. For example,
isSubsequence("computer", "core") false
isSubsequence("computer", "cope") true
isSubsequence("computer", "computer") true
 */
fun isSubsequence(str: String, sub: String): Boolean {
    if (sub.isEmpty()) return true
    if (str.isEmpty()) return false

    return isSubsequence(str.substring(1), if (str[0] == sub[0]) sub.substring(1) else sub)
}