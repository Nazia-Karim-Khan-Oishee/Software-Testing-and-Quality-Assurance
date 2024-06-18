package code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VehicleTest {

    @Test
    public void testVehicleConstructorforCar() {
        String vehicleId = "1234";
        int year = 2022;
        String make = "Toyota";
        String model = "Camry";
        int status = 1;
        VehicleType vehicleType = new VehicleType(7); // Example vehicle type
        Vehicle vehicle = new Vehicle(vehicleId, year, make, model, status, vehicleType);

        assertEquals(vehicleId, vehicle.Vehicle_id);
        assertEquals(year, vehicle.Year);
        assertEquals(make, vehicle.Make);
        assertEquals(model, vehicle.Model);
        assertEquals(status, vehicle.vehicleStatus);
        assertEquals(vehicleType, vehicle.vehicleType);
    }


    @Test
    public void testVehicleConstructorVan() {
        String vehicleId = "1234";
        int year = 2022;
        String make = "Toyota";
        String model = "Camry";
        int status = 1;
        DateTime lastMaintenance = new DateTime(1,1,2022);
        VehicleType vehicleType = new VehicleType(7, lastMaintenance);
        Vehicle vehicle = new Vehicle(vehicleId, year, make, model, status, vehicleType);

        assertEquals(vehicleId, vehicle.Vehicle_id);
        assertEquals(year, vehicle.Year);
        assertEquals(make, vehicle.Make);
        assertEquals(model, vehicle.Model);
        assertEquals(status, vehicle.vehicleStatus);
        assertEquals(vehicleType, vehicle.vehicleType);
    }



    @Test
    public void testgetVehicleId() {
        String vehicleId = "1234";
        int year = 2022;
        String make = "Toyota";
        String model = "Camry";
        int status = 1; // Example status value
        DateTime lastMaintenance = new DateTime(1,1,2022);
        VehicleType vehicleType = new VehicleType(7, lastMaintenance);
        Vehicle vehicle = new Vehicle(vehicleId, year, make, model, status, vehicleType);

        assertEquals(vehicleId, vehicle.getVehicleId());

    }


    @Test
    public void testRent_whenVehicleStatusNotAvailable() {

        VehicleType vehicleType = mock(VehicleType.class);
        when(vehicleType.canBeRentedForMinimumDays(any(), any())).thenReturn(2); // Mock the canBeRentedForMinimumDays method

        Vehicle vehicle = new Vehicle("C_1234", 2022, "Toyota", "Camry", 1, vehicleType);


        boolean result = vehicle.rent("customer123", mock(DateTime.class), 3);


        assertFalse(result);
    }


    @Test
    public void testRent_whenNumOfRentDayLessThanMinimumDays() {

        VehicleType vehicleType = mock(VehicleType.class);
        when(vehicleType.canBeRentedForMinimumDays(any(), any())).thenReturn(5); // Mock the canBeRentedForMinimumDays method

        Vehicle vehicle = new Vehicle("C_1234", 2022, "Toyota", "Camry", 0, vehicleType);


        boolean result = vehicle.rent("customer123", mock(DateTime.class), 3);

        assertFalse(result);
    }

    @Test
    public void testRent_whenNumOfRentDayExceedsMaximumDays() {
        VehicleType vehicleType = mock(VehicleType.class);
        when(vehicleType.canBeRentedForMinimumDays(any(), any())).thenReturn(2); // Mock the canBeRentedForMinimumDays method

        Vehicle vehicle = new Vehicle("C_1234", 2022, "Toyota", "Camry", 0, vehicleType);

        boolean result = vehicle.rent("customer123", mock(DateTime.class), 14);

        assertFalse(result);
    }

    @Test
    public void testRent_whenTypeOfVehicleIsVanAndUnderMaintenance() {
        VehicleType vehicleType = mock(VehicleType.class);
        when(vehicleType.canBeRentedForMinimumDays(any(), any())).thenReturn(2); // Mock the canBeRentedForMinimumDays method
        when(vehicleType.IsUnderMaintenance(any(), any(), anyInt())).thenReturn(true); // Mock the IsUnderMaintenance method with anyInt()

        Vehicle vehicle = new Vehicle("V_5678", 2022, "Ford", "Transit", 0, vehicleType);

        boolean result = vehicle.rent("customer123", mock(DateTime.class), 3);

        assertFalse(result);
    }

    @Test
    public void testRent_whenTypeOfVehicleIsVanAndNotUnderMaintenance() {
        VehicleType vehicleType = mock(VehicleType.class);
        when(vehicleType.canBeRentedForMinimumDays(any(), any())).thenReturn(2); // Mock the canBeRentedForMinimumDays method
        when(vehicleType.IsUnderMaintenance(any(), any(), anyInt())).thenReturn(false); // Mock the IsUnderMaintenance method with anyInt()

        Vehicle vehicle = new Vehicle("V_5678", 2022, "Ford", "Transit", 0, vehicleType);

        boolean result = vehicle.rent("customer123", mock(DateTime.class), 3);

        assertTrue(result);
    }

    @Test
    public void testRent_whenTypeOfVehicleIsNotVan() {
        VehicleType vehicleType = mock(VehicleType.class);
        when(vehicleType.canBeRentedForMinimumDays(any(), any())).thenReturn(2); // Mock the canBeRentedForMinimumDays method

        Vehicle vehicle = new Vehicle("C_1234", 2022, "Toyota", "Camry", 0, vehicleType);

        boolean result = vehicle.rent("customer123", mock(DateTime.class), 3);

        assertTrue(result);
    }


    @Test
    public void testPerformMaintenance_whenStatus0() {
        VehicleType vehicleType = mock(VehicleType.class);

        Vehicle vehicle = new Vehicle("C_1234", 2022, "Toyota", "Camry", 0, vehicleType);

        boolean result = vehicle.performMaintenance();

        assertTrue(result);
        assertEquals(2, vehicle.vehicleStatus);
    }

    @Test
    public void testPerformMaintenance_whenStatus1() {
        VehicleType vehicleType = mock(VehicleType.class);

        Vehicle vehicle = new Vehicle("C_1234", 2022, "Toyota", "Camry", 1, vehicleType);

        boolean result = vehicle.performMaintenance();

        assertFalse(result);
        assertEquals(1, vehicle.vehicleStatus);
    }

    @Test
    public void testPerformMaintenance_whenStatus2() {
         VehicleType vehicleType = mock(VehicleType.class);
        Vehicle vehicle = new Vehicle("C_1234", 2022, "Toyota", "Camry", 2, vehicleType);

        boolean result = vehicle.performMaintenance();

        assertFalse(result);
        assertEquals(2, vehicle.vehicleStatus);
    }

    @Test
    public void testToString_whenVehicleIsAvailable() {
        VehicleType vehicleType = mock(VehicleType.class);
        when(vehicleType.getSeats("van")).thenReturn(15); // Mock the getSeats method for van

        Vehicle vehicle = new Vehicle("V_1234", 2022, "Ford", "Transit", 0, vehicleType);

        String result = vehicle.toString();

        assertEquals("V_1234:2022:Ford:Transit:15:Available", result);
    }

    @Test
    public void testToString_whenVehicleIsRented() {
        VehicleType vehicleType = mock(VehicleType.class);
        when(vehicleType.getSeats("car")).thenReturn(5); // Mock the getSeats method for car

        Vehicle vehicle = new Vehicle("C_5678", 2022, "Toyota", "Camry", 1, vehicleType);

        String result = vehicle.toString();

        assertEquals("C_5678:2022:Toyota:Camry:5:Rented", result);
    }

    @Test
    public void testToString_whenVehicleIsUnderMaintenance() {
        VehicleType vehicleType = mock(VehicleType.class);
        when(vehicleType.getSeats("van")).thenReturn(15); // Mock the getSeats method for van

        Vehicle vehicle = new Vehicle("V_9012", 2022, "Honda", "Odyssey", 2, vehicleType);

        String result = vehicle.toString();

        assertEquals("V_9012:2022:Honda:Odyssey:15:Maintenance", result);
    }

    @Test
    public void testGetLastElementIndex() {
        Vehicle vehicle = new Vehicle("C_001", 2020, "Toyota", "Camr", 1, new VehicleType(5));
        vehicle.records[0] = new RentalRecord("1", new DateTime(), new DateTime());
        vehicle.records[1] = new RentalRecord("2", new DateTime(), new DateTime());
        vehicle.records[2] = new RentalRecord("2", new DateTime(), new DateTime());
        assertEquals(2, vehicle.getLastElementIndex());
    }

}
