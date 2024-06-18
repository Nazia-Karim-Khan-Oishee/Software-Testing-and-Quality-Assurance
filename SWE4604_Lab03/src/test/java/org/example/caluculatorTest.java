package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class caluculatorTest {

    @Test
    public void testAdd() {
        caluculator cal = new caluculator();
        int result = cal.add(3, 4);
        assertEquals(7, result);
    }

}