package com.ratulsarna.algorithmexercises.datastructures

import java.lang.IndexOutOfBoundsException

class SinglyLinkedList<T> : MyList<T> {

    private var head: Node<T>? = null
    private var size = 0

    override fun add(item: T) {
        if (head == null)
            head = Node(item, null)
        else {
            var ptr = head
            while (ptr?.next != null) {
                ptr = ptr.next
            }
            ptr?.next = Node(item, null)
        }

        size += 1
    }

    override fun add(index: Int, item: T) {
        if (index > size || index < 0) throw IndexOutOfBoundsException()

        if (head == null) {
            add(item)
        } else {

            var ptr = head
            for (i in 0 until index-1) {
                ptr = ptr?.next
            }
            ptr?.next = Node(item, ptr?.next)

            size += 1
        }
    }

    override fun removeAt(index: Int) {
        if (index >= size || index < 0) throw IndexOutOfBoundsException()

        if (size == 1) {
            head = null
        } else {

            var ptr = head
            for (i in 0 until index-1) {
                ptr = ptr?.next
            }
            ptr?.next = ptr?.next?.next
        }
        size -= 1
    }

    override fun get(index: Int): T {
        if (index >= size || index < 0) throw IndexOutOfBoundsException()

        var ptr = head
        for (i in 0..index) {
            ptr = ptr?.next
        }
        return ptr?.item!!
    }

    override fun size(): Int {
        return size
    }

    override fun toString(): String {
        var str = ""
        var ptr = head
        while (ptr != null) {
            str += "${ptr.item}, "
            ptr = ptr.next
        }
        return str
    }
}

private data class Node<T>(
    val item: T,
    var next: Node<T>?
)