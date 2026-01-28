package org.example.restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantServiceTest {

    private RestaurantService restaurantService;

    @BeforeEach
    void setUp() {
        restaurantService = new RestaurantService();
    }

    @Test
    void testFindRestaurants_Italian() {
        String result = restaurantService.findRestaurants("Italian");
        assertNotNull(result);
        assertTrue(result.contains("Italian Restaurants"));
        assertTrue(result.contains("La Pasta House"));
    }

    @Test
    void testFindRestaurants_Default() {
        String result = restaurantService.findRestaurants("UnknownCuisine");
        assertNotNull(result);
        assertTrue(result.contains("No restaurants found"));
    }

    @Test
    void testMakeReservation() {
        String result = restaurantService.makeReservation("La Pasta House", "2023-12-25", "19:00", 4, "John Doe");
        assertNotNull(result);
        assertTrue(result.contains("Reservation confirmed"));
        assertTrue(result.contains("Reservation ID"));
    }

    @Test
    void testOrderTakeout() {
        String result = restaurantService.orderTakeout("Taj Palace", "Butter Chicken", "Jane Doe", "555-0199");
        assertNotNull(result);
        assertTrue(result.contains("Takeout order confirmed"));
        assertTrue(result.contains("Order ID"));
    }

    @Test
    void testGetPopularDishes_TajPalace() {
        String result = restaurantService.getPopularDishes("Taj Palace");
        assertNotNull(result);
        assertTrue(result.contains("Butter Chicken"));
    }

    @Test
    void testGetPopularDishes_NotFound() {
        String result = restaurantService.getPopularDishes("Unknown Restaurant");
        assertNotNull(result);
        assertTrue(result.contains("Restaurant not found"));
    }

    @Test
    void testCheckReservation_Found() {
        // First make a reservation to ensure one exists
        String reservationResponse = restaurantService.makeReservation("La Pasta House", "2023-12-25", "19:00", 2,
                "Test User");
        // Extract ID (simplified extraction, assuming format)
        // Format: Reservation confirmed! Reservation ID: la pasta
        // house-2023-12-25-19:00
        // The ID in the code is: String.format("%s-%s-%s", restaurantName, date,
        // time).toLowerCase();
        String expectedId = "la pasta house-2023-12-25-19:00";

        String result = restaurantService.checkReservation(expectedId);
        assertNotNull(result);
        assertTrue(result.contains("Reservation found"));
        assertTrue(result.contains("Test User"));
    }

    @Test
    void testCheckReservation_NotFound() {
        String result = restaurantService.checkReservation("non-existent-id");
        assertNotNull(result);
        assertTrue(result.contains("No reservation found"));
    }

    @Test
    void testCheckTakeoutStatus_Found() {
        // Since order ID uses System.currentTimeMillis(), we need to parse it or
        // capture it from the return string logic if possible,
        // or just test the logic flow if we can't easily predict the ID.
        // However, the test is running in a single thread, so we can try to grab the ID
        // if we parse the response string.
        // Or simpler: The ID logic in the service is: String.format("TO-%s-%s",
        // restaurantName, System.currentTimeMillis()).toLowerCase();
        // Let's rely on the service returning the ID in the confirmation message.

        String orderResponse = restaurantService.orderTakeout("Szechuan Palace", "Dumplings", "Test User", "555-1234");
        // string format: ... Order ID: <id>\n...

        String[] lines = orderResponse.split("\n");
        String idLine = lines[0]; // "Takeout order confirmed! Order ID: to-szechuan palace-..."
        String id = idLine.substring(idLine.lastIndexOf(":") + 1).trim();

        String result = restaurantService.checkTakeoutStatus(id);
        assertNotNull(result);
        assertTrue(result.contains("Order found"));
        assertTrue(result.contains("Dumplings"));
    }

    @Test
    void testCheckTakeoutStatus_NotFound() {
        String result = restaurantService.checkTakeoutStatus("non-existent-order-id");
        assertNotNull(result);
        assertTrue(result.contains("No order found"));
    }
}
