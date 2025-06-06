package org.example.desert;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Agent(groupName = "dessertOperations", groupDescription = "Manage dessert operations like finding sweets and recipes")
@Slf4j
public class DessertService {

    public DessertService() {
        log.info("Created Dessert Service");
    }

    @Action(description = "Find popular Indian sweets")
    public String findIndianSweets() {
        log.info("Fetching popular Indian sweets");
        return "Popular Indian Sweets: Gulab Jamun, Jalebi, Rasgulla, Kaju Katli";
    }

    @Action(description = "Find popular Italian sweets")
    public String findItalianSweets() {
        log.info("Fetching popular Italian sweets");
        return "Popular Italian Sweets: Tiramisu, Cannoli, Panna Cotta, Gelato";
    }

    @Action(description = "Get a quick recipe for Gulab Jamun")
    public String quickGulabJamunRecipe() {
        log.info("Fetching quick Gulab Jamun recipe");
        return "Quick Gulab Jamun Recipe: Mix milk powder, flour, and baking soda. Knead into dough, shape into balls, fry, and soak in sugar syrup.";
    }
}
