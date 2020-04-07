package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class AddressBookTest {
    private AddressBook actual = new AddressBook();
    private HashMap<String, Address> expected = new HashMap<>();

    @org.junit.jupiter.api.Test
    void adds() {
        expected.put("Петров", new Address("Ленина", 15, 45));
        actual.add("Петров", new Address("Ленина", 15, 45));
        Assert.assertEquals(expected, actual.person);
        Assert.assertFalse(actual.add("Петров", new Address("Ленина", 15, 45)));
        expected.remove("Петров");
        Assert.assertNotEquals(expected, actual.person);
        Assert.assertFalse(actual.add("Сидоров", new Address(null, 15, 45)));

    }

    @Test
    void delete() {
        expected.put("Петров", new Address("Ленина", 15, 45));
        actual.add("Петров", new Address("Ленина", 15, 45));
        actual.add("Васильев", new Address("Пушкина", 14, 55));
        actual.delete("Петров");
        Assert.assertNotEquals(expected, actual.person);
        actual.delete("Васильев");
        actual.add("Петров", new Address("Ленина", 15, 45));
        Assert.assertEquals(expected, actual.person);
        Assert.assertFalse(actual.delete("Иванов"));
        Assert.assertFalse(actual.delete(null));

    }

    @org.junit.jupiter.api.Test
    void changeAdress() {
        expected.put("Соболев", new Address("Мерецкова", 3, 6));
        expected.put("Соболева", new Address("Мерецкова", 3, 6));
        actual.add("Соболев", new Address("Пашкова", 1, 2));
        actual.add("Соболева", new Address("Пашкова", 1, 2));
        Assert.assertNotEquals(expected, actual.person);
        actual.changeAddress("Соболев", new Address("Мерецкова", 3, 6));
        actual.changeAddress("Соболева", new Address("Мерецкова", 3, 6));
        Assert.assertEquals(expected, actual.person);
        Assert.assertFalse(actual.changeAddress("Иванов", new Address("Мерецкова", 3, 6)));
        Assert.assertFalse(actual.changeAddress(null, new Address(null, 14,13)));
    }

    @org.junit.jupiter.api.Test
    void getAddress() {
        actual.add("Соболев", new Address("Пашкова", 1, 2));
        actual.add("Соболева", new Address("Пашкова", 1, 2));
        actual.add("Петров", new Address("Ленина", 15, 45));
        expected.put("Соболев", new Address("Пашкова", 1, 2));
        expected.put("Соболева", new Address("Пашкова", 1, 2));
        expected.put("Петров", new Address("Ленина", 15, 45));
        Assert.assertEquals(expected.get("Соболев"), actual.getAddress("Соболев"));
        Assert.assertEquals(expected.get("Соболева"), actual.getAddress("Соболева"));
        Assert.assertEquals(expected.get("Петров"), actual.getAddress("Петров"));
        Assert.assertNull(actual.getAddress("Иванов"));
        Assertions.assertThrows(NullPointerException.class, () ->
                actual.getAddress(null));

    }

    @org.junit.jupiter.api.Test
    void whoLifeStreet() {
        ArrayList<String> expectedL1 = new ArrayList<>();
        expectedL1.add("Соболев");
        expectedL1.add("Соболева");
        ArrayList<String> expectedL2 = new ArrayList<>();
        expectedL2.add("Петров");
        ArrayList<String> exception = new ArrayList<>();
        actual.add("Соболев", new Address("Пашкова", 1, 2));
        actual.add("Соболева", new Address("Пашкова", 1, 2));
        actual.add("Петров", new Address("Ленина", 15, 45));
        Assert.assertEquals(expectedL1, actual.whoLifeStreet("Пашкова"));
        Assert.assertEquals(expectedL2, actual.whoLifeStreet("Ленина"));
        Assert.assertEquals(exception, actual.whoLifeStreet("Мерецкова"));
        Assertions.assertThrows(NullPointerException.class, () ->
                actual.whoLifeStreet(null));
    }

    @org.junit.jupiter.api.Test
    void whoLifeHouse() {
        ArrayList<String> expectedL1 = new ArrayList<>();
        expectedL1.add("Соболев");
        expectedL1.add("Соболева");
        ArrayList<String> expectedL2 = new ArrayList<>();
        expectedL2.add("Петров");
        ArrayList<String> exception = new ArrayList<>();
        actual.add("Соболев", new Address("Пашкова", 1, 2));
        actual.add("Соболева", new Address("Пашкова", 1, 2));
        actual.add("Петров", new Address("Ленина", 15, 45));
        Assert.assertEquals(expectedL1, actual.whoLifeHouse(2));
        Assert.assertEquals(expectedL2, actual.whoLifeHouse(45));
        Assert.assertEquals(exception, actual.whoLifeStreet("Мерецкова"));
    }
}