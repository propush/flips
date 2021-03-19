package com.pushkin.flips

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class FlipCounterTest {

    private lateinit var flipCounter: FlipCounter

    @Before
    fun setUp() {
        flipCounter = FlipCounter()
    }

    @Test
    fun count() {
        assertEquals(
            arrayListOf(2, 3, 4),
            flipCounter.count(
                arrayListOf(0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1)
            )
        )
    }

    @Test
    fun generate() {
        assertEquals(10, flipCounter.generate(10).size)
    }
}