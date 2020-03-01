package com.company;

class Triplet {
    private String street;
    private int house;
    private int room;

    Triplet(String street, int streetNum, int room) {
        this.street = street;
        this.house = streetNum;
        this.room = room;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNum() {
        return house;
    }

    public int getRoom() {
        return room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Triplet my = (Triplet) o;
        return street.equals(my.street) && room == my.room && house == my.house;
    }
    @Override
    public final int hashCode() {
        int result = street.hashCode();
        result = 31 * result + house;
        result = 31 * result + room;
        return result;
    }
}