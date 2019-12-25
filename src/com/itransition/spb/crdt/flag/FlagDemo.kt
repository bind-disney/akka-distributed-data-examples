package com.itransition.spb.crdt.flag

fun main() {
    val flag1 = Flag.create()
    val flag2 = flag1.switchOn()

    println(flag1.enabled())
}
