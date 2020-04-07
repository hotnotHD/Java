package com.company;

import java.util.*;

public class AddressBook {
    HashMap<String, Address> person = new HashMap<>();
/* При попытке использования методов add, delete или changeAddress с null, выводится false,
* методы не логического типа кидают исключения, кроме поиска по дому, т.к int не даст записать в себя null*/
    public boolean add(String family, Address STnums) {
        if (family == null || STnums.getStreet() == null) {
            return false;
        }
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

    public boolean changeAddress(String name, Address STnums) {
        if (person.containsKey(name)) {
            person.put(name, STnums);
            return true;
        } else return false;
    }

    public Address getAddress(String name) {
        if (name == null) {
            throw new NullPointerException();
        }return person.get(name);
    }

    public List<String> whoLifeStreet(String streetIn) {
        if (streetIn == null) {
            throw new NullPointerException();
        }
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, Address> entry : person.entrySet()) {
            String name = entry.getKey();
            Address value = entry.getValue();
            if (value.getStreet().equals(streetIn)) {
                names.add(name);
            }
        }
        return names;
    }

    public List<String> whoLifeHouse(int houseIn) {
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, Address> entry : person.entrySet()) {
            String name = entry.getKey();
            Address value = entry.getValue();
            if (value.getRoom() == (houseIn)) {
                names.add(name);
            }
        }
        return names;
    }
}
