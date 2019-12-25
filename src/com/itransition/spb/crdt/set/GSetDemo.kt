package com.itransition.spb.crdt.set

fun main() {
    val set0 = GSet.create<String>()
    val set1 = set0.add("a")
    val set2 = set1.add("b").add("c")

    if ("a" in set2) {
        println(set2.elements) // a, b, c
    }
}
