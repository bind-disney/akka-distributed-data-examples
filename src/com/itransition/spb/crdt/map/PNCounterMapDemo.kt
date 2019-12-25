package com.itransition.spb.crdt.map

fun main() {
    val node = DistributedData.get(system).selfUniqueAddress()

    val map0 = PNCounterMap.create<String>()
    val map1 = map0.increment(node, "a", 7)
    val map2 = map1.decrement(node, "a", 2)
    val map3 = map2.increment(node, "b", 1)

    println(map3["a"]) // 5
    println(map3.entries)
}
