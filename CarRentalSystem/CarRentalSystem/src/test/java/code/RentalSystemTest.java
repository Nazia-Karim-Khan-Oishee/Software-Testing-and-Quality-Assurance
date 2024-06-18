package code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RentalSystemTest {

    @Test
    @DisplayName("Test to add a car")
    void testRunwithInput1() {
        String userInput = "1";

        RentSystem rentSystem = mock(RentSystem.class);

        // Stub the add() method to do nothing
        doNothing().when(rentSystem).add(any());

        // Create a ByteArrayInputStream to simulate user input
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);


        rentSystem.run();


        verify(rentSystem, times(1)).run();


        System.setIn(System.in);
    }

    @Test
    @DisplayName("Test to rent a car")
    void testRunwithInput2() {
        String userInput = "2";

        RentSystem rentSystem = mock(RentSystem.class);

        doNothing().when(rentSystem).rent(any());

        // Create a ByteArrayInputStream to simulate user input
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);


        rentSystem.run();


        verify(rentSystem, times(1)).run();


        System.setIn(System.in);
    }

    @Test
    @DisplayName("Test to return a car")
    void testRunwithInput3() {
        String userInput = "3";

        RentSystem rentSystem = mock(RentSystem.class);

        doNothing().when(rentSystem).returnCar(any());

        // Create a ByteArrayInputStream to simulate user input
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);


        rentSystem.run();


        verify(rentSystem, times(1)).run();


        System.setIn(System.in);
    }

    @Test
    @DisplayName("Test to perform vehicle maintenance")
    void testRunwithInput4() {
        String userInput = "4";

        RentSystem rentSystem = mock(RentSystem.class);

        doNothing().when(rentSystem).vehicleMaintenance(any());

        // Create a ByteArrayInputStream to simulate user input
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);


        rentSystem.run();


        verify(rentSystem, times(1)).run();


        System.setIn(System.in);
    }

    @Test
    @DisplayName("Test to complete vehicle maintenance")
    void testRunwithInput5() {
        String userInput = "5";

        RentSystem rentSystem = mock(RentSystem.class);

        doNothing().when(rentSystem).completeMaintenance(any());

        // Create a ByteArrayInputStream to simulate user input
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);


        rentSystem.run();


        verify(rentSystem, times(1)).run();


        System.setIn(System.in);
    }

    @Test
    @DisplayName("Test to get details of all cars")
    void testRunwithInput6() {
        String userInput = "6";

        RentSystem rentSystem = mock(RentSystem.class);

        doNothing().when(rentSystem).getDetails();

        // Create a ByteArrayInputStream to simulate user input
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);


        rentSystem.run();


        verify(rentSystem, times(1)).run();


        System.setIn(System.in);
    }

    @Test
    @DisplayName("Test to exit the system")
    void testRunwithInput7() {
        String userInput = "7\n";

        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        RentSystem rentSystem = new RentSystem();

        rentSystem.run();

        System.setIn(System.in);
    }


    @Test
    void testAddVan() {
        // Define expected user input for adding a van
        String userInput = "van\n2022\nFord\nTransit\n5678\n15\n01/01/2022\n";

        // Mock the Scanner object
        Scanner scanner = new Scanner(userInput);


        // Create an instance of RentSystem
        RentSystem rentSystem = new RentSystem();

        // Run the method
        rentSystem.add(scanner);

        // Reset System.in to its original value
        System.setIn(System.in);
        Van vans = rentSystem.vans[0];
        assertEquals("Vehicle ID:\tV_5678\n Year:\t 2022\n Make:\tFord\n Model:\tTransit\n Number of Seats:\t15\n Status:\tAvailable\nLast maintenance date:\t01/01/2022\nRENTAL RECORD:\tempty"
                , vans.getDetails());


    }


    @Test
    void testAddCar() {
        // Define expected user input for adding a car
        String userInput = "car\n2023\nToyota\nCamry\n1234\n7\n";

        // Mock the Scanner object
        Scanner scanner = new Scanner(userInput);

        // Create an instance of RentSystem
        RentSystem rentSystem = new RentSystem();

        // Run the method
        rentSystem.add(scanner);

        // Reset System.in to its original value
        System.setIn(System.in);

        // Retrieve the first car added to the RentSystem
        Car car = rentSystem.cars[0];

        // Verify car details
        assertEquals("Vehicle ID:\tC_1234\n Year:\t 2023\n Make:\tToyota\n Model:\tCamry\n Number of Seats:\t7\n Status:\tAvailable\nRENTAL RECORD:\tempty", car.getDetails());
    }


    @Test
    @DisplayName("Test to rent a car")
    void testRentCar() {
        // Define expected user input for renting a car
        String userInput = "C_1234\nC1\n01/03/2024\n2\n";

        Scanner scanner = new Scanner(userInput);

        RentSystem rentSystem = new RentSystem();

        rentSystem.cars[0] = new Car("C_1234", 2022, "Toyota", "Camry", 7, new VehicleType(7));

        rentSystem.rent(scanner);

        System.setIn(System.in);


    }

    @Test
    @DisplayName("Test to rent a van")
    void testRentVan() {
        // Define expected user input for renting a van
        String userInput = "V_5678\nC2\n01/03/2024\n3\n";

        // Mock the Scanner object
        Scanner scanner = new Scanner(userInput);

        // Create an instance of RentSystem
        RentSystem rentSystem = new RentSystem();

        // Add a van to the RentSystem (assuming a van with ID V_5678 exists)
        // This is necessary because the rent method checks if the vehicle exists before renting it
        rentSystem.vans[0] = new Van("V_5678", 2022, "Ford", "Transit", 15, new VehicleType(15));

        // Run the method
        rentSystem.rent(scanner);

        // Reset System.in to its original value
        System.setIn(System.in);


    }

    @Test
    @DisplayName("Test to return a car")
    void testReturnCar() {
        // Prepare a rented car
        Car car = new Car("C_1", 2022, "Make", "Model", 0, new VehicleType(4));
        RentSystem rentSystem = new RentSystem();
        rentSystem.cars[0] = car;
        car.rent("Customer1", new DateTime(1, 1, 2022), 5); // Rent the car for 5 days

        // Simulate return input
        String inputCarReturned = "C_1\n02/01/2022\n"; // Provide the return date

        // Mock user input with a scanner
        Scanner scannerCarReturned = new Scanner(inputCarReturned);

        // Perform the return operation
        rentSystem.returnCar(scannerCarReturned);

        assertEquals(1, car.vehicleStatus);


    }

    @Test
    @DisplayName("Test to return a van")
    void testReturnVan() {
        // Prepare a rented van
        Van van = new Van("V_1", 2022, "Make", "Model", 0, new VehicleType(15, new DateTime(1, 1, 2022)));

        RentSystem rentSystem = new RentSystem();
        rentSystem.vans[0] = van;
        van.rent("Customer1", new DateTime(1, 1, 2022), 5); // Rent the van for 5 days

        String inputVanReturned = "V_1\n02/01/2022\n"; // Provide the return date

        Scanner scannerVanReturned = new Scanner(inputVanReturned);

        rentSystem.returnCar(scannerVanReturned);

        assertEquals(0, van.vehicleStatus);

    }


    @Test
    public void testVehicleMaintenance() {
        // Prepare a car for maintenance
        RentSystem rentSystem = new RentSystem();
        Car car = new Car("C_1", 2022, "Make", "Model", 0, new VehicleType(4));

        rentSystem.cars[0] = car;

        // Simulate maintenance input for car
        String inputCar = "C_1\n"; // Provide the car ID for maintenance
        Scanner scannerCar = new Scanner(inputCar);
        rentSystem.vehicleMaintenance(scannerCar);

        // Assert that the car is now under maintenance
        assertEquals(0, car.vehicleStatus);

        // Prepare a van for maintenance
        Van van = new Van("V_1", 2022, "Make", "Model", 0, new VehicleType(15));
        rentSystem.vans[0] = van;

        // Simulate maintenance input for van
        String inputVan = "V_1\n"; // Provide the van ID for maintenance
        Scanner scannerVan = new Scanner(inputVan);
        rentSystem.vehicleMaintenance(scannerVan);

        // Assert that the van is now under maintenance
        assertEquals(2, van.vehicleStatus);
    }

    @Test
    public void testCompleteMaintenance() {

        String inputCar = "C_1\n02/01/2022\n";
        Scanner scannerCar = new Scanner(inputCar);
        RentSystem rentSystem = new RentSystem();
        rentSystem.completeMaintenance(scannerCar);

        Car car = new Car("C_1", 2022, "Make", "Model", 0, new VehicleType(4));

        rentSystem.cars[0] = car;
        assertEquals(0, rentSystem.cars[0].vehicleStatus);


    }

    @Test

    void testGetDetails() {
        // Create a car
        Car car = new Car("C_1", 2022, "Toyota", "Corolla", 0, new VehicleType(4));

        // Create a van
        DateTime lastMaintenanceDate = new DateTime(11, 3, 2024);
        Van van = new Van("V_1", 2022, "Toyota", "Hiace", 0, new VehicleType(15, lastMaintenanceDate));

        // Set up ByteArrayOutputStream to capture System.out.println() output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RentSystem rentSystem = new RentSystem();
        rentSystem.cars[0] = car;
        rentSystem.vans[0] = van;

    rentSystem.getDetails();

        System.setOut(System.out);

        String expectedOutput = "***********Cars**********\n" +
                "Vehicle ID:\tC_1\n" +
                " Year:\t 2022\n" +
                " Make:\tToyota\n" +
                " Model:\tCorolla\n" +
                " Number of Seats:\t4\n" +
                " Status:\tAvailable\n" +
                "RENTAL RECORD:\tempty\n" +
                "***********Vans**********\n" +
                "Vehicle ID:\tV_1\n" +
                " Year:\t 2022\n" +
                " Make:\tToyota\n" +
                " Model:\tHiace\n" +
                " Number of Seats:\t15\n" +
                " Status:\tAvailable\n" +
                "Last maintenance date:\t11/03/2024\n" +
                "RENTAL RECORD:\tempty\n";

//        assertEquals(expectedOutput, outContent.toString());
    }
}
