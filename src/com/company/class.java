package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AddressBook {
    HashMap<String, Triplet> person = new HashMap<>();

    public boolean adds(String family, Triplet STnums) {
        if (!person.containsKey(family)) {
            person.put(family, STnums);
            return true;
        }
        return false;
    }

    public boolean delete(String name) {
        if (person.containsKey(name)) {
            person.remove(name);
            return true;
        } else return false;
    }

    public boolean changeAdress(String name, Triplet STnums) {
        if (person.containsKey(name)) {
            person.put(name, STnums);
            return true;
        } else return false;
    }

    public Triplet getAdress(String name) {
            return person.get(name);
    }

    public List<String> whoLifeStreet(String streetIn) {
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, Triplet> entry : person.entrySet()) {
            String name = entry.getKey();
            Triplet value = entry.getValue();
            if (value.getStreet().equals(streetIn)) {
                names.add(name);
            }
        }
        return names;
    }

    public List<String> whoLifeRoom(int roomIn) {
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, Triplet> entry : person.entrySet()) {
            String name = entry.getKey();
            Triplet value = entry.getValue();
            if (value.getRoom() == (roomIn)) {
                names.add(name);
            }
        }
        return names;
    }
}
