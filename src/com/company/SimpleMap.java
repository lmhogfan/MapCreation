package com.company;

import java.util.HashMap;
import java.util.Map;

public class SimpleMap
{
    public static void main(String [] args)
    {
        SimpleMap simpleMap= new SimpleMap();
        simpleMap.demo();
    }

    public void demo()
    {
        Map<String, String> newMap= new HashMap<>();
        Map<String, String> countries= new HashMap<>();
        countries.put("USA", "United States");
        countries.put("MEX", "Mexico");
        countries.put("CAN", "Canada");

        System.out.println(countries.get("USA"));
        System.out.println(countries.get("CAN"));
        countries.put("USA", "United States 2");
        System.out.println(countries.get("USA"));
        countries.remove("USA");

        System.out.println(countries);
    }
}
