package com.itransition.spb.crdt.map

fun main() {
    val node = DistributedData.get(system).selfUniqueAddress()

    val map0 = ORMultiMap.create<String, Int>()
    val map1 = map0.put(node, "a", setOf<Int>(1, 2, 3))
    val map2 = map1.addBinding(node, "a", 4)
    val map3 = map2.removeBinding(node, "a", 2)
    val map4 = map3.addBinding(node, "b", 1)

    println(map4.entries)
}
