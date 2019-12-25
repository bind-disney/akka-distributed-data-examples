package com.itransition.spb.crdt.custom

class TwoPhaseSet<T>(private val adds: GSet<T>, private val removals: GSet<T>) :
    AbstractReplicatedData<TwoPhaseSet<T>>() {

    operator fun plus(element: T) = TwoPhaseSet(adds.add(element), removals)

    operator fun minus(element: T) = TwoPhaseSet(adds, removals.add(element))

    val elements: Set<T>
        get() = setOf(adds.elements) - setOf(removals.elements)

    override fun mergeData(that: TwoPhaseSet<T>) = TwoPhaseSet(adds.merge(that.adds), removals.merge(that.removals))

    companion object {
        fun create() = TwoPhaseSet(GSet.create(), GSet.create())
    }
}
