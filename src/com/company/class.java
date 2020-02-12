package com.company;

import javafx.util.Pair;

import java.util.HashMap;

class adressBook {
    HashMap<String, Pair<String,String>> vse = new HashMap<>();
    void adds(String family, Pair<String, String> STnums){
        if (!vse.containsKey(family))
        vse.put(family,STnums);
    }
    void delete (String name){
        vse.remove(name);
    }
    void changeAdress(String name, Pair<String, String> STnums){
        if (vse.containsKey(name)){
            vse.remove(name);
            vse.put(name,STnums);
        }
    }
    Pair<String,String> getAdress(String name) {
        return vse.get(name);
    }
}
