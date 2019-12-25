package com.itransition.spb.crdt.register

fun main() {
    val node: SelfUniqueAddress = DistributedData.get(system).selfUniqueAddress()

    val register1: LWWRegister<String> = LWWRegister.create(node, "Hello")
    val register2: LWWRegister<String> = register1.withValue(node, "Hi")

    println("${register1.value()} by ${register1.updatedBy()} at ${register1.timestamp()}")
}
