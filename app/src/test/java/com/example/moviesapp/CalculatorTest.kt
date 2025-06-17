package com.example.moviesapp

import com.example.moviesapp.learnTest.Calculator
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun testAddition() {
        val result = calculator.add(3, 2)
        assertEquals(5, result)
    }

    @Test
    fun testSubtraction() {
        val result = calculator.subtract(5, 3)
        assertEquals(2, result)
    }

    @Test
    fun testMultiplication() {
        val result = calculator.multiply(2,2)
        assertEquals(4, result)
    }

    @Test
    fun testDivision() {
        val result = calculator.divide(10, 2)
        assertEquals(5, result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testDivisionByZero_shouldThrowException() {
        calculator.divide(10, 0)
    }
}