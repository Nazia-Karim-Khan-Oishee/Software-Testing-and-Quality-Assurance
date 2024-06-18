package code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTypeTest {

    @Test
    void testGetSeatsForCar() {
        VehicleType car = new VehicleType(4);
        assertEquals(4, car.getSeats("car"));
    }



    @Test
    void testGetSeatsForVan() {
        VehicleType van = new VehicleType(10, null); // LastMaintenance is not relevant for this test
        assertEquals(10, van.getSeats("van"));
    }

    @Test
    void testIndexOfValidDay() {
        VehicleType vehicle = new VehicleType(4);
        assertEquals(0, vehicle.indexOf("Sunday"));
        assertEquals(1, vehicle.indexOf("Monday"));

    }

    @Test
    void testIndexOfInvalidDay() {
        VehicleType vehicle = new VehicleType(4);
        assertEquals(-1, vehicle.indexOf("InvalidDay"));
    }


    @Test
    void testGetLastMaintenance() {
        DateTime lastMaintenance = new DateTime(13, 2, 2024);
        VehicleType van = new VehicleType(4, lastMaintenance);
        assertEquals(lastMaintenance, van.getLastMaintenance());
    }

    @Test
    void testSetLastMaintenance() {
        DateTime lastMaintenance = new DateTime(13, 2, 2024);
        VehicleType van = new VehicleType(4, lastMaintenance);
       van.setLastMaintenance(lastMaintenance);
       assertEquals(lastMaintenance, van.getLastMaintenance());
    }

    @Test
    void testCanBeRentedForMinimumDaysWeekdayCar() {
        DateTime weekday = new DateTime(13,03,2024);
        VehicleType car = new VehicleType(4);
        assertEquals(2, car.canBeRentedForMinimumDays(weekday, "car"));
    }

    // Test for weekend and car
    @Test
    void testCanBeRentedForMinimumDaysWeekendCar() {
        // Assuming 'date' represents a weekend day
        DateTime weekendDay = new DateTime(1,03,2024);
        VehicleType car = new VehicleType(4);
        assertEquals(3, car.canBeRentedForMinimumDays(weekendDay, "car"));
    }

    // Test for van
    @Test
    void testCanBeRentedForMinimumDaysVan() {
        DateTime date = new DateTime(13,03,2024);
        VehicleType van = new VehicleType(15);
        assertEquals(1, van.canBeRentedForMinimumDays(date, "van"));
    }

    @Test
    void testIsUnderMaintenanceWhenVanNotUnderMaintenance() {
        DateTime rentDate = new DateTime(13, 3, 2024);
        VehicleType van = new VehicleType(15, new DateTime(10,3,2024));
        assertFalse(van.IsUnderMaintenance(rentDate, "van", 5));
    }

//     Test for van under maintenance but rental period within maintenance period
    @Test
    void testIsUnderMaintenanceWhenVanUnderMaintenanceWithinPeriod() {
        DateTime rentDate = new DateTime(13, 3, 2024);
        VehicleType van = new VehicleType(15, new DateTime(2,3,2024));
        assertTrue(van.IsUnderMaintenance(rentDate, "van", 10));
    }


    // Test for car
    @Test
    void testIsUnderMaintenanceCar() {
        DateTime rentDate = new DateTime(13, 3, 2024);
        VehicleType car = new VehicleType(4,rentDate);
        assertFalse(car.IsUnderMaintenance(rentDate, "car", 3));
    }
}
