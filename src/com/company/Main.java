package com.company;


public class Main {

    public static void main(String[] args) {
        adressBook adresses = new adressBook();
        adresses.adds("Ковалевский", new Triplet("Воронина",22,15));
        adresses.adds("Пушкарев", new Triplet("Ленина",15,15));
        adresses.delete("Ковалевский");
        adresses.changeAdress("Пушкарев", new Triplet("Ленина",13,32));
        adresses.adds("Ковалевский", new Triplet("Ленина",22,15));
        adresses.adds("Ыуыр", new Triplet("Пленина",22,15));
        Triplet ss = new Triplet("ss",15,34);
        System.out.println(adresses.getAdress("Пушкарев"));
        System.out.println(ss.getFlat());
        System.out.println(adresses.whoLifeStreet("Ленина"));
        System.out.println(adresses.whoLifeFlat(15));
    }
}
