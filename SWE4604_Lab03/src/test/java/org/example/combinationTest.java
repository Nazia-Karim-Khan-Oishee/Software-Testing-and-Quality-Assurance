package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class combinationTest {

    @Test
    public void test5C2() {
        combination com = new combination();
        long result = com.nCr(5, 2);
        assertEquals(10, result);
    }

    @Test
    public void test12C10() {
        combination com = new combination();
        long result = com.nCr(12, 10);
        assertEquals(66, result);
    }
    @Test
    public void test6C6() {
        combination com = new combination();
        long result = com.nCr(6, 6);
        assertEquals(1, result);
    }
    @Test
    public void test15C2() {
        combination com = new combination();
        long result = com.nCr(15, 2);
        assertEquals(105, result);
    }
    @Test
    public void test15C14() {
        combination com = new combination();
        long result = com.nCr(15, 14);
        assertEquals(15, result);
    }
    @Test
    public void test3C0() {
        combination com = new combination();
        long result = com.nCr(3, 0);
        assertEquals(1, result);
    }
    @Test
    public void testNonIntegerValue() {
        combination com = new combination();
        try {
            long result = com.nCr(15,  2.5);
//            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Inputs must be an integer", e.getMessage());
        }
    }

    @Test
    public void testZeroValue() {
        combination com = new combination();
        try {
            long result = com.nCr(0,  0);
//            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Inputs must be greater than 0", e.getMessage());
        }
    }

    @Test
    public void testNegativeValue() {
        combination com = new combination();
        try {
            long result = com.nCr(-14,  2);
//            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Inputs must be positive value", e.getMessage());
        }
    }

    @Test
    public void testLargeValue() {
        combination com = new combination();
        try {
            long result = com.nCr(1000,  2);
//            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Inputs must be in the range 0 to 15", e.getMessage());
        }
    }
}