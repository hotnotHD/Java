package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        adressBook adresses = new adressBook();
        ArrayList vse2 = adresses.vse;
        vse2.add(adressBook.name());
        vse2.add(adressBook.adds());
        System.out.print(vse2.get(0));
        System.out.print(" - ");
        System.out.print(vse2.get(1));
        System.out.print(vse2.get(0).toString().contains("Кова"));

    }
}
