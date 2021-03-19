package com.pushkin.flips

import kotlin.random.Random

class FlipCounter {

    fun generate(maxFlips: Int, states: Int = 2) =
        arrayListOf<Int>()
            .also { value ->
                repeat((0 until maxFlips).count()) {
                    value.add(getRandom(states))
                }
            }

    fun count(values: ArrayList<Int>): ArrayList<Int> =
        arrayListOf<Int>()
            .also { counters ->
                var counter = 0
                values.forEachIndexed { index, value ->
                    if (index > 0) {
                        val prevValue = values[index - 1]
                        if (prevValue == value) {
                            ++counter
                        } else {
                            addCounterIfNeeded(counter, counters)
                            counter = 0
                        }
                    }
                }
                addCounterIfNeeded(counter, counters)
            }

    private fun addCounterIfNeeded(counter: Int, counters: ArrayList<Int>) {
        if (counter > 0) {
            counters.add(counter + 1)
        }
    }

    private fun getRandom(states: Int) =
        Random.nextInt(states)

    fun getMedian(list: List<Int>): Int {
        list
            .filter { it > 0 }
            .sorted()
            .also {
                if (it.isEmpty()) {
                    return 0
                }
                if (it.size == 1) {
                    return it[0]
                }
                val middle = it.size / 2
                return if (it.size % 2 == 0) {
                    (it[middle] + it[middle - 1]) / 2
                } else {
                    it[middle + 1]
                }
            }
    }

}
