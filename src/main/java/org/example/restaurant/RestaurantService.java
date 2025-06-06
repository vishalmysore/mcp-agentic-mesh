package org.example.restaurant;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
@Agent(groupName = "restaurantOperations", groupDescription = "Manage restaurant operations like finding restaurants, making reservations, and ordering takeout")
@Slf4j
public class RestaurantService {

    private final Map<String, String> reservations = new HashMap<>();
    private final Map<String, String> takeoutOrders = new HashMap<>();

    public RestaurantService() {
        log.info("Created Restaurant Service");
    }

    @Action(description = "Find restaurants by cuisine type")
    public String findRestaurants(String cuisineType) {
        log.info("Finding restaurants for cuisine type: '{}'", cuisineType);
        switch(cuisineType.toLowerCase()) {
            case "italian":
                return "Italian Restaurants: La Pasta House (4.5★), Milano's Pizza (4.3★), Tuscany Bistro (4.7★)";
            case "indian":
                return "Indian Restaurants: Taj Palace (4.6★), Spice Garden (4.4★), Delhi Darbar (4.2★)";
            case "chinese":
                return "Chinese Restaurants: Golden Dragon (4.5★), Wok & Roll (4.3★), Szechuan Palace (4.6★)";
            case "japanese":
                return "Japanese Restaurants: Sushi Master (4.8★), Ramen House (4.4★), Tokyo Express (4.2★)";
            default:
                return "No restaurants found for the specified cuisine type. Try: Italian, Indian, Chinese, or Japanese";
        }
    }

    @Action(description = "Make a restaurant reservation")
    public String makeReservation(String restaurantName, String date, String time, int partySize, String name) {
        log.info("Making reservation at '{}' for {} people", restaurantName, partySize);
        String reservationId = String.format("%s-%s-%s", restaurantName, date, time).toLowerCase();
        String reservationDetails = String.format(
            "Restaurant: %s, Date: %s, Time: %s, Party Size: %d, Name: %s",
            restaurantName, date, time, partySize, name
        );
        reservations.put(reservationId, reservationDetails);
        return String.format("Reservation confirmed! Reservation ID: %s\n%s", 
            reservationId, reservationDetails);
    }

    @Action(description = "Order takeout from a restaurant")
    public String orderTakeout(String restaurantName, String items, String name, String phone) {
        log.info("Creating takeout order for '{}' from {}", name, restaurantName);
        String orderId = String.format("TO-%s-%s", restaurantName, System.currentTimeMillis()).toLowerCase();
        String orderDetails = String.format(
            "Restaurant: %s\nItems: %s\nCustomer: %s\nPhone: %s",
            restaurantName, items, name, phone
        );
        takeoutOrders.put(orderId, orderDetails);
        return String.format("Takeout order confirmed! Order ID: %s\n%s", 
            orderId, orderDetails);
    }

    @Action(description = "Get restaurant's popular dishes")
    public String getPopularDishes(String restaurantName) {
        log.info("Fetching popular dishes for '{}'", restaurantName);
        switch(restaurantName.toLowerCase()) {
            case "la pasta house":
                return "Popular dishes at La Pasta House: Fettuccine Alfredo, Spaghetti Carbonara, Margherita Pizza, Tiramisu";
            case "taj palace":
                return "Popular dishes at Taj Palace: Butter Chicken, Naan Bread, Biryani, Gulab Jamun";
            case "golden dragon":
                return "Popular dishes at Golden Dragon: Kung Pao Chicken, Dim Sum, Mapo Tofu, Peking Duck";
            case "sushi master":
                return "Popular dishes at Sushi Master: Dragon Roll, Salmon Nigiri, Ramen, Mochi Ice Cream";
            default:
                return "Restaurant not found in our database. Please try one of our featured restaurants.";
        }
    }

    @Action(description = "Check reservation status")
    public String checkReservation(String reservationId) {
        log.info("Checking reservation status for ID: '{}'", reservationId);
        String reservation = reservations.get(reservationId.toLowerCase());
        return reservation != null ? 
            "Reservation found:\n" + reservation : 
            "No reservation found with ID: " + reservationId;
    }

    @Action(description = "Check takeout order status")
    public String checkTakeoutStatus(String orderId) {
        log.info("Checking takeout order status for ID: '{}'", orderId);
        String order = takeoutOrders.get(orderId.toLowerCase());
        return order != null ? 
            "Order found:\n" + order : 
            "No order found with ID: " + orderId;
    }
}
