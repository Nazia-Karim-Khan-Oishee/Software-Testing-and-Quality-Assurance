package code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DateTimeTest {

    // Test for default constructor
    @Test
    void testDefaultConstructor() {
        DateTime dateTime = new DateTime();
        assertNotNull(dateTime);
    }

    // Test for constructor with setClockForwardInDays
    @Test
    void testConstructorWithSetClockForwardInDays() {
        DateTime dateTime = new DateTime(5);
        assertNotNull(dateTime);
    }

    // Test for constructor with startDate and setClockForwardInDays
    @Test
    void testConstructorWithStartDateAndSetClockForwardInDays() {
        DateTime startDate = new DateTime(10, 3, 2024); // March 10, 2024
        DateTime dateTime = new DateTime(startDate, 7);
        assertNotNull(dateTime);
    }

    // Test for constructor with day, month, and year
    @Test
    void testConstructorWithDayMonthYear() {
        DateTime dateTime = new DateTime(13, 3, 2024); // March 13, 2024
        assertNotNull(dateTime);
    }



    // Test for getNameOfDay()
    @Test
    void testGetNameOfDay() {
        DateTime dateTime = new DateTime(13, 3, 2024); // March 13, 2024
        String expectedDayName = "Wednesday";
        assertEquals(expectedDayName, dateTime.getNameOfDay());
    }

    // Test for toString()
    @Test
    void testToString() {
        DateTime dateTime = new DateTime(13, 3, 2024); // March 13, 2024
        String expectedString = "13/03/2024"; // Assuming the date format is "dd/MM/yyyy"
        assertEquals(expectedString, dateTime.toString());
    }

    // Test for getCurrentTime()
    @Test
    void testGetCurrentTime() {
        String currentTime = DateTime.getCurrentTime();
        assertNotNull(currentTime);
    }
    @Test
    void testGetFormattedDate() {
        DateTime dateTime = new DateTime(13, 3, 2024); // March 13, 2024
        String expectedFormattedDate = "13/03/2024";
        assertEquals(expectedFormattedDate, dateTime.getFormattedDate());
    }

    // Test for getEightDigitDate()
    @Test
    void testGetEightDigitDate() {
        DateTime dateTime = new DateTime(13, 3, 2024); // March 13, 2024
        String expectedEightDigitDate = "13032024";
        assertEquals(expectedEightDigitDate, dateTime.getEightDigitDate());
    }

    // Test for diffDays()
    @Test
    void testDiffDays() {
        DateTime startDate = new DateTime(10, 3, 2024); // March 10, 2024
        DateTime endDate = new DateTime(15, 3, 2024); // March 15, 2024
        int expectedDiff = 5;
        assertEquals(expectedDiff, DateTime.diffDays(endDate, startDate));
    }
}
