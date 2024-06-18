package code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentalRecordTest {

    private RentalRecord rentalRecord;

    @BeforeEach
    public void setUp() {
        DateTime rentDate = new DateTime(10, 3, 2024); // March 10, 2024
        DateTime estimatedReturnDate = new DateTime(15, 3, 2024); // March 15, 2024
        rentalRecord = new RentalRecord("123", rentDate, estimatedReturnDate); // Assign to the instance variable
    }

    @Test
    void testSetData() {
        DateTime actualReturnDate = new DateTime(15, 3, 2024); // March 15, 2024
        Double rentalFee = 50.0;
        Double lateFee = 10.0;
        rentalRecord.setData(actualReturnDate, rentalFee, lateFee);


        assertEquals(actualReturnDate, rentalRecord.ActualReturnDate);
        assertEquals(rentalFee, rentalRecord.RentalFee);
        assertEquals(lateFee, rentalRecord.LateFee);
    }

    @Test
    void testToString() {
        String expectedToString = "123:10/03/2024:15/03/2024:none:none:none";
        assertEquals(expectedToString, rentalRecord.toString());
    }

    @Test
    void testGetDetails() {
        String expectedDetails =
                "Record ID:             123\n" +
                        "Rent Date:             10/03/2024\n" +
                        "Estimated Return Date: 15/03/2024";
        assertEquals(expectedDetails, rentalRecord.getDetails());
    }
}
