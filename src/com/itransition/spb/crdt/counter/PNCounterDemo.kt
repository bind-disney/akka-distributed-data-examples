package com.itransition.spb.crdt.counter

fun main() {
    val node = DistributedData.get(system).selfUniqueAddress()

    val counter0 = PNCounter.create()
    val counter1 = counter0.increment(node, 1)
    val counter2 = counter1.increment(node, 7)
    val counter3 = counter2.decrement(node, 2)

    println(counter3.value()); // 6
}
