package com.ratulsarna.algorithmexercises

import com.ratulsarna.algorithmexercises.datastructures.Stack
import com.sun.org.apache.xpath.internal.operations.Bool
import jdk.nashorn.internal.objects.NativeArray.forEach
import java.util.*
import kotlin.collections.HashMap

/*
Write a recursive function called makeChange that takes in a target amount of change and a Vector of
coin values and prints out every way of making that amount of change, using only the coin values in
coins. For example, if you need to make change using only pennies, nickels, and dimes, the coins
vector would be {1, 5, 10}. Each way of making change should be printed as the number of each
coin used in the coins vector. For example, if you were to use the above coins vector to make change
for 15 cents, the possibilities would be
{15, 0, 0}, {10, 1, 0}, {5, 2, 0}, {5, 0, 1}, {0, 3, 0}, {0, 1, 1}
In the outputs for the example, the rst element of each vector indicates the number of pennies used,
the second indicates the number of nickels, and the third indicates the number of dimes
 */
fun makeChange(coins: List<Int>) {

}


/*
Write a recursive function named partitionable that takes a reference to a Vector of integers and
returns whether or not it is possible to divide the values into two groups such that each group has the
same sum. For example, the vector {1,1,2,3,5} can be split into {1,5} and {1,2,3}, both of which
sum to 6. However, the vector {1,4,5,6} can't be split into two vectors with the same sum.
 */
fun partitionable(list: List<Int>): Boolean {
//    return partitionableHelper(mutableListOf(), list.toMutableList())
    return partitionableHelper2(list.toMutableList(), 0, 0)
}

fun partitionableHelper(soFar: MutableList<Int>, remaining: MutableList<Int>): Boolean {
    if (soFar.sum() == remaining.sum()) return true
    if (remaining.isEmpty()) return false

    val size = remaining.size
    for (i in 0 until size) {
        soFar.add(remaining[i])
        val removed = remaining.removeAt(i)
        if (partitionableHelper(soFar, remaining)) return true
        soFar.removeAt(soFar.size-1)
        remaining.add(i, removed)
    }
    return false
}

// Attempt 2 - after consulting solution
fun partitionableHelper2(list: MutableList<Int>, sumOne: Int, sumTwo: Int): Boolean {
    if (list.isEmpty()) {
        return sumOne == sumTwo
    }

    val first = list[0]
    list.removeAt(0)
    if (partitionableHelper2(list, sumOne + first, sumTwo)) return true
    if (partitionableHelper2(list, sumOne, sumTwo + first)) return true
    list.add(0,first)
    return false
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