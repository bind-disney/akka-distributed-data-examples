package com.itransition.spb.crdt.set

fun main() {
    val node = DistributedData.get(system).selfUniqueAddress()

    val set0 = ORSet.create<String>()
    val set1 = set0.add(node, "a")
    val set2 = set1.add(node, "b")
    val set3 = set2.remove(node, "a")

    println(set3.elements) // b
}
