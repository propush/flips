package com.pushkin.flips

fun main(args: Array<String>) {
    FlipCounter()
        .apply {
            val stats = hashMapOf<Int, ArrayList<Int>>()
            for (epoch in 0..99) {
                val cnt = count(generate(1000, 2))
                println("Grouped sequences: (total: ${cnt.size}) $cnt")
                for (i in 5..20) {
                    cnt.count { it == i }.also { c ->
                        println("$i in a row: $c")
                        stats[i] = stats.getOrDefault(i, arrayListOf()).also { it.add(c) }
                    }
                }
            }
            stats.forEach { (k, v) ->
                val average = v.sum() / v.size
                val median = this.getMedian(v)
                val max = v.max()
                println("$k average: $average, median: $median, max: $max")
            }
        }
}
