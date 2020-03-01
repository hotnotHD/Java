package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class AddressBookTest {
    private AddressBook actual = new AddressBook();
    private HashMap<String, Triplet> expected = new HashMap<>();

    @org.junit.jupiter.api.Test
    void adds() {
        expected.put("Петров", new Triplet("Ленина", 15, 45));
        actual.adds("Петров", new Triplet("Ленина", 15, 45));
        Assert.assertEquals(expected, actual.person);
        Assert.assertFalse(actual.adds("Петров", new Triplet("Ленина", 15, 45)));
        expected.remove("Петров");
        Assert.assertNotEquals(expected, actual.person);
    }

    @Test
    void delete() {
        expected.put("Петров", new Triplet("Ленина", 15, 45));
        actual.adds("Петров", new Triplet("Ленина", 15, 45));
        actual.adds("Васильев", new Triplet("Пушкина", 14, 55));
        actual.delete("Петров");
        Assert.assertNotEquals(expected, actual.person);
        actual.delete("Васильев");
        actual.adds("Петров", new Triplet("Ленина", 15, 45));
        Assert.assertEquals(expected, actual.person);
        Assert.assertFalse(actual.delete("Иванов"));
    }

    @org.junit.jupiter.api.Test
    void changeAdress() {
        expected.put("Соболев", new Triplet("Мерецкова", 3, 6));
        expected.put("Соболева", new Triplet("Мерецкова", 3, 6));
        actual.adds("Соболев", new Triplet("Пашкова", 1, 2));
        actual.adds("Соболева", new Triplet("Пашкова", 1, 2));
        Assert.assertNotEquals(expected, actual.person);
        actual.changeAdress("Соболев", new Triplet("Мерецкова", 3, 6));
        actual.changeAdress("Соболева", new Triplet("Мерецкова", 3, 6));
        Assert.assertEquals(expected, actual.person);
        Assert.assertFalse(actual.changeAdress("Иванов", new Triplet("Мерецкова", 3, 6)));
    }

    @org.junit.jupiter.api.Test
    void getAdress() {
        actual.adds("Соболев", new Triplet("Пашкова", 1, 2));
        actual.adds("Соболева", new Triplet("Пашкова", 1, 2));
        actual.adds("Петров", new Triplet("Ленина", 15, 45));
        expected.put("Соболев", new Triplet("Пашкова", 1, 2));
        expected.put("Соболева", new Triplet("Пашкова", 1, 2));
        expected.put("Петров", new Triplet("Ленина", 15, 45));
        Assert.assertEquals(expected.get("Соболев"), actual.getAdress("Соболев"));
        Assert.assertEquals(expected.get("Соболева"), actual.getAdress("Соболева"));
        Assert.assertEquals(expected.get("Петров"), actual.getAdress("Петров"));
        Assert.assertNull(actual.getAdress("Иванов"));
    }

    @org.junit.jupiter.api.Test
    void whoLifeStreet() {
        ArrayList<String> expectedL1 = new ArrayList<>();
        expectedL1.add("Соболев");
        expectedL1.add("Соболева");
        ArrayList<String> expectedL2 = new ArrayList<>();
        expectedL2.add("Петров");
        ArrayList<String> exception = new ArrayList<>();
        actual.adds("Соболев", new Triplet("Пашкова", 1, 2));
        actual.adds("Соболева", new Triplet("Пашкова", 1, 2));
        actual.adds("Петров", new Triplet("Ленина", 15, 45));
        Assert.assertEquals(expectedL1, actual.whoLifeStreet("Пашкова"));
        Assert.assertEquals(expectedL2, actual.whoLifeStreet("Ленина"));
        Assert.assertEquals(exception, actual.whoLifeStreet("Мерецкова"));
    }

    @org.junit.jupiter.api.Test
    void whoLifeRoom() {
        ArrayList<String> expectedL1 = new ArrayList<>();
        expectedL1.add("Соболев");
        expectedL1.add("Соболева");
        ArrayList<String> expectedL2 = new ArrayList<>();
        expectedL2.add("Петров");
        ArrayList<String> exception = new ArrayList<>();
        actual.adds("Соболев", new Triplet("Пашкова", 1, 2));
        actual.adds("Соболева", new Triplet("Пашкова", 1, 2));
        actual.adds("Петров", new Triplet("Ленина", 15, 45));
        Assert.assertEquals(expectedL1, actual.whoLifeRoom(2));
        Assert.assertEquals(expectedL2, actual.whoLifeRoom(45));
        Assert.assertEquals(exception, actual.whoLifeStreet("Мерецкова"));
    }
}