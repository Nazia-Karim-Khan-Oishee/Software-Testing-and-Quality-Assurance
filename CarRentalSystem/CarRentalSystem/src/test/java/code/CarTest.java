package code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        VehicleType vehicleType = new VehicleType(4);
        car = new Car("C_1234", 2022, "Toyota", "Camry", 0, vehicleType);

    }

    @Test
    public void testGetLateFeeWhenEndDateIsAfterStartDate() {
        DateTime startDate = new DateTime(1, 1, 2022); // January 1st, 2022
        DateTime endDate = new DateTime(4, 1, 2022); // January 4th, 2022

        double lateFee = car.getLateFee(endDate, startDate);

        assertEquals(1.25 *78  * DateTime.diffDays(endDate, startDate), lateFee); // Assuming rent rate is 78 and difference in days is 3
    }

    @Test
    public void testGetLateFeeWhenEndDateIsSameAsStartDate() {
        DateTime startDate = new DateTime(1, 1, 2022); // January 1st, 2022
        DateTime endDate = new DateTime(1, 1, 2022); // January 1st, 2022

        double lateFee = car.getLateFee(endDate, startDate);

        assertEquals(0.0, lateFee, 0.001); // No late fee as the dates are the same
    }

    @Test
    public void testGetLateFeeWhenEndDateIsBeforeStartDate() {
        DateTime startDate = new DateTime(4, 1, 2022); // January 4th, 2022
        DateTime endDate = new DateTime(1, 1, 2022); // January 1st, 2022

        double lateFee = car.getLateFee(endDate, startDate);

        assertEquals(0.0, lateFee, 0.001); // No late fee as the end date is before the start date
    }



    @Test
    @DisplayName("Test returnVehicle when the car is not rented")
    public void testReturnVehicle() {
        assertFalse(car.returnVehicle(new DateTime()));
    }


    @Test
    public void testReturnVehicleBeforeMinimumDays() {
        car.rent("Customer1", new DateTime(10,4,2024), 3);
        assertTrue(car.returnVehicle(new DateTime(12,4,2024)));
    }
    @Test
    public void testReturnVehicleAfterMaximumDays() {
        car.rent("Customer2", new DateTime(10,3,2024), 13);
        assertTrue(car.returnVehicle(new DateTime(27,3,2024)));
    }


    @Test
    public void testCompleteMaintenanceWhenStatus2() {
        car.vehicleStatus=2;

        assertTrue(car.completeMaintenance());

        assertEquals(0, car.vehicleStatus);
    }
    @Test
    public void testGetDetailsWhenNoRentalRecords() {
        assertEquals("Vehicle ID:\tC_1234\n Year:\t 2022\n Make:\tToyota\n Model:\tCamry\n Number of Seats:\t4\n Status:\tAvailable\nRENTAL RECORD:\tempty", car.getDetails());
    }

    @Test
    public void testGetDetailsWithRentalRecord() {
        DateTime rentDate = new DateTime(1, 1, 2022);
        DateTime returnDate = new DateTime(5, 1, 2022);
        RentalRecord rentalRecord = new RentalRecord("R_1", rentDate, returnDate);
        car.records[0] = rentalRecord;

        String expectedDetails = "Vehicle ID:\tC_1234\n Year:\t 2022\n Make:\tToyota\n Model:\tCamry\n Number of Seats:\t4\n Status:\tAvailable\nRENTAL RECORD\n";
        expectedDetails += rentalRecord.getDetails() + "                     \n";
        expectedDetails += "----------                     \n";

        assertEquals(expectedDetails, car.getDetails());
    }
}
