package code;

import static org.junit.jupiter.api.Assertions.*;

import code.DateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VanTest {
    private Van van;

    @BeforeEach
    public void setUp() {
        VehicleType vehicleType = new VehicleType(4, new DateTime(28, 12, 2023));
        van = new Van("V_5678", 2022, "Ford", "Transit", 0, vehicleType);
    }
    @Test
    public void testGetLateFeeWhenEndDateIsAfterStartDate() {

        DateTime startDate = new DateTime(2022, 1, 1);
        DateTime endDate = new DateTime(2022, 1, 5);
        assertEquals(299 * DateTime.diffDays(endDate,startDate), van.getLateFee(endDate, startDate));
    }

    @Test
    public void testGetLateFeeWhenEndDateIsBeforeStartDate() {

        DateTime startDate = new DateTime(2022, 1, 5);
        DateTime endDate = new DateTime(2022, 1, 1);
        assertEquals(0.0, van.getLateFee(endDate, startDate));
    }

    @Test
    public void testGetLateFeeWhenEndDateIsSameAsStartDate() {
        DateTime startDate = new DateTime(2022, 1, 1);
        DateTime endDate = new DateTime(2022, 1, 1);
        assertEquals(0.0, van.getLateFee(endDate, startDate));
    }
    @Test
    @DisplayName("Test completeMaintenance when van is not under maintenance ")
    public void testCompleteMaintenanceAfter12Days() {
        assertFalse(van.completeMaintenance(new DateTime(10, 1, 2024)));
    }

    @Test
    @DisplayName("Test completeMaintenance when van is under maintenance ")
    public void testCompleteMaintenanceUnderMaintenanceWithin12Days() {
        van.vehicleStatus=2;

        assertTrue(van.completeMaintenance(new DateTime(14, 1, 2024)));
        assertEquals(0, van.vehicleStatus); // Van status should be available
    }

    @Test
    @DisplayName("Test returnVehicle when the vehicle is not rented")
    public void testReturnVehicleWhenNotRented() {
        van.vehicleStatus=0; // Van is not rented
        assertFalse(van.returnVehicle(new DateTime(14, 1, 2024)));
    }

    @Test
    @DisplayName("Test returnVehicle when the vehicle is a van and returned within 1 day of the rental")
    public void testReturnVanWithin1DayOfRental() {
        // Rent the van for 1 day
        van.vehicleStatus=2;
        van.rent("customer123", new DateTime(), 1);
        DateTime rentDate = new DateTime(14, 1, 2024);
        DateTime returnDate = new DateTime(22, 1, 2024);
        RentalRecord rentalRecord = new RentalRecord("R_1", rentDate, returnDate);
        van.records[0] = rentalRecord;
        assertFalse(van.returnVehicle(new DateTime(14, 1, 2024)));
    }

    @Test
    @DisplayName("Test returnVehicle when the vehicle is a van and returned after the rental period")
    public void testReturnVanAfterRentalPeriod() {
        van.vehicleStatus=2;
        // Rent the van for 3 days
        van.rent("customer123", new DateTime(), 1);
        DateTime rentDate = new DateTime(14, 1, 2024);
        DateTime returnDate = new DateTime(22, 1, 2024);
        RentalRecord rentalRecord = new RentalRecord("R_1", rentDate, returnDate);
        van.records[0] = rentalRecord;
        assertTrue(van.returnVehicle(new DateTime(22, 1, 2024)));
    }


}
