package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class adressBook {
    ArrayList vse = new ArrayList();
    static String adds(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер квартиры: ");
        String h = in.next();
        System.out.print("Введите номер улицы: ");
        String s = in.next();
        System.out.print("Введите улицу: ");
        String n = in.next();
        return n + " " + s + ", кв. " + h;
    }
    static String name() {
        System.out.print("Введите фамилию: ");
        Scanner in = new Scanner(System.in);
        return in.next();
    }
}
