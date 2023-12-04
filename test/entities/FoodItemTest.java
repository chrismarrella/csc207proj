package entities;

import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class FoodItemTest {

    private String name;
    private Calendar expirationDate;
    private Float amount;

    @BeforeEach
    void setUp() {
        name = "Apple";
        expirationDate = Calendar.getInstance();
        expirationDate.set(Calendar.YEAR, 2024);
        expirationDate.set(Calendar.MONTH, 1);
        expirationDate.set(Calendar.DAY_OF_MONTH, 1);
        amount = 1.0f;
    }

    @Test
    void testGetExpirationDate() {
        FoodItem foodItem = new FoodItem(name, 2024, 1, 1, 1.0f);
        assertEquals("2024/1/1", foodItem.getExpirationDate());
    }

    @Test
    void testGetName() {
        FoodItem foodItem = new FoodItem(name, 2024, 1, 1, 1.0f);
        assertEquals(name, foodItem.getName());
    }

    @Test
    void testGetAmount() {
        FoodItem foodItem = new FoodItem(name, 2024, 1, 1, 1.0f);
        assertEquals(amount, foodItem.getAmount());
    }

    @Test
    void testSetAmount() {
        FoodItem foodItem = new FoodItem(name, 2024, 1, 1, 1.0f);
        foodItem.setAmount(2.0f);
        assertEquals(2.0f, foodItem.getAmount());
    }
}