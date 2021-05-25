package com.example.practicerecyclerview;

import java.util.ArrayList;
import java.util.Random;

public class Contact {

    String name;
    String phone;
    int avatar;

    public Contact(String name, String phone, int avatar) {
        this.name = name;
        this.phone = phone;
        this.avatar = avatar;
    }

    public static ArrayList<Contact> getMockData() {

        ArrayList<Contact> contacts = new ArrayList<>();

        String [] name = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii", "jjj"};
        String [] phone = {"111", "222", "333", "444", "555", "666", "777", "888", "999", "000"};

        Random random = new Random();

        for (int i = 0; i < name.length; i++)
        {
            contacts.add(new Contact(name[i], phone[i], random.nextInt(4)));
        }
        return contacts;
    }
}
