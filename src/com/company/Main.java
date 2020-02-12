package com.company;

import javafx.util.Pair;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        adressBook adresses = new adressBook();
        adresses.adds("Ковалевский", new Pair<>("Воронина 20","22"));
        adresses.adds("Пушкарев", new Pair<>("Ленина 16","65"));
        adresses.delete("Ковалевский");
        adresses.changeAdress("Пушкарев", new Pair<>("Ленина 26","13"));
        System.out.println(adresses.vse);
        System.out.println(adresses.getAdress("Пушкарев"));
    }
}
