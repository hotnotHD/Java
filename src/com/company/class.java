package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class adressBook {
    HashMap<String, Triplet> vse = new HashMap<>();

    void adds(String family, Triplet STnums){
        if (!vse.containsKey(family))
        vse.put(family,STnums);
    }

    void delete (String name){
        if (vse.containsKey(name)){
            vse.remove(name);
        } else throw new NullPointerException("Такой фамилии не существует");
    }

    void changeAdress(String name, Triplet STnums){
        if (vse.containsKey(name)){
            vse.remove(name);
            vse.put(name,STnums);
        } else throw new NullPointerException("Такой фамилии не существует");
    }

    String getAdress(String name){
        if (vse.containsKey(name)){
            return vse.get(name).getStreet() + " " + vse.get(name).getStreetNum() + " " + vse.get(name).getFlat();
        } else throw new NullPointerException("Такой фамилии не существует");
    }

    ArrayList<String> whoLifeStreet(String streetIn){
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String,Triplet> entry : vse.entrySet())
        {
            String name = entry.getKey();
            Triplet value = entry.getValue();
            if (value.getStreet().equals(streetIn)){
                names.add(name);
            }
        }
        return names;
    }

    ArrayList<String> whoLifeFlat(int flatIn){
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String,Triplet> entry : vse.entrySet())
        {
            String name = entry.getKey();
            Triplet value = entry.getValue();
            if (value.getFlat() == (flatIn)){
                names.add(name);
            }
        }
        return names;
    }
}

class Triplet {
    private String street;
    private int house;
    private int flat;

    Triplet(String street, int streetNum, int flat){
        this.flat = flat;
        this.street = street;
        this.house = streetNum;
    }
    String getStreet(){
        return street;
    }
    int getStreetNum(){
        return house;
    }
    int getFlat(){
        return flat;
    }
}
