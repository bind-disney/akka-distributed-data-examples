package com.itransition.spb.crdt.register

data class Record(val version: Long, val name: String, val address: String)

fun main() {
    val node = DistributedData.get(system).selfUniqueAddress()

    val recordClock = LWWRegister.Clock<Record>() {
        override fun apply(currentTimestamp: Long, value: Record) = value.version
    }

    val record1 = Record(1, "Alice", "Union Square")
    val register1: LWWRegister<Record> = LWWRegister.create(node, record1, recordClock)

    val record2 = Record(2, "Alice", "Madison Square")
    val register2: LWWRegister<Record> = LWWRegister.create(node, record2, recordClock)

    val register3: LWWRegister<Record> = register1.merge(register2)

    println(register3.value())
}
