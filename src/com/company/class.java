package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class adressBook {
    HashMap<String, Triplet> vse = new HashMap<>();

    void adds(String family, Triplet STnums) {
        if (!vse.containsKey(family))
            vse.put(family, STnums);
    }

    void delete(String name) {
        if (vse.containsKey(name)) {
            vse.remove(name);
        } else throw new NullPointerException("Людей, с такой фамилией, в списках нет");
    }

    void changeAdress(String name, Triplet STnums) {
        if (vse.containsKey(name)) {
            vse.remove(name);
            vse.put(name, STnums);
        } else throw new NullPointerException("Людей, с такой фамилией, в списках нет");
    }

    String getAdress(String name) {
        if (vse.containsKey(name)) {
            return vse.get(name).getStreet() + " " + vse.get(name).getStreetNum() + " " + vse.get(name).getRoom();
        } else return "Людей, с такой фамилией, в списках нет";
    }

    ArrayList<String> whoLifeStreet(String streetIn) {
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, Triplet> entry : vse.entrySet()) {
            String name = entry.getKey();
            Triplet value = entry.getValue();
            if (value.getStreet().equals(streetIn)) {
                names.add(name);
            }
        }
        if (names.isEmpty()) names.add("Людей, живущих на этой улице, нет");
        return names;
    }

    ArrayList<String> whoLifeRoom(int roomIn) {
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, Triplet> entry : vse.entrySet()) {
            String name = entry.getKey();
            Triplet value = entry.getValue();
            if (value.getRoom() == (roomIn)) {
                names.add(name);
            }
        }
        if (names.isEmpty()) names.add("Людей, живущих в данных квартирах, нет");
        return names;
    }
}

class Triplet {
    private String street;
    private int house;
    private int room;

    Triplet(String street, int streetNum, int room) {
        this.street = street;
        this.house = streetNum;
        this.room = room;
    }

    String getStreet() {
        return street;
    }

    int getStreetNum() {
        return house;
    }

    int getRoom() {
        return room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Triplet my = (Triplet) o;
        return street.equals(my.street) && room == my.room && house == my.house;
    }
}
