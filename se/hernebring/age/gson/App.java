package se.hernebring.age.gson;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Person p = new Person("Cat Stevens", 80);
        System.out.println(gson.toJson(p));
    }
}