package com.targetindia.programs;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>((a, b) -> b.compareTo(a)); // try with LinkedHashMap and HashMap
        map.put("vinod", "9731424784");
        map.put("shyam", "9000080000");
        map.put("kiran", "8900067000");
        map.put("vinod", "9844083934");
        map.put("kishore", "9280082700");
        map.put("nagesh", null);
        map.put("arun", "9280082200");
        map.put("anil", "9212342700");

        System.out.printf("There are %d entries.%n", map.size());
        System.out.printf("%s's phone number is %s%n", "vinod", map.get("vinod"));
        System.out.printf("%s's phone number is %s%n", "nagesh", map.get("nagesh"));

        String name = "vishal";
        if (map.containsKey(name)) {
            System.out.printf("%s's phone number is %s%n", name, map.get(name));
        } else {
            System.out.printf("No entry found for key '%s'%n", name);
        }

        String phone = "98440839341";
        if (map.containsValue(phone)) {
            System.out.printf("%s exists in the map%n", phone);
        } else {
            System.out.printf("%s was not found in the map%n", phone);
        }

        // how to loop over a Map (which is not an Iterable object)?
        // method 1: iterate over the set of keys
        for (String key : map.keySet()) {
            System.out.printf("%s --> %s%n", key, map.get(key));
        }

        // method 2: iterate over the collection of values
        for (String value : map.values()) {
            System.out.println(value);
        }

        // method 3: iterate over the set of Entry objects (an Entry contains key+value)
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s --> %s%n", entry.getKey(), entry.getValue());
        }

    }
}
