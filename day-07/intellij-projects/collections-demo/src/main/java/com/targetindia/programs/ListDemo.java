package com.targetindia.programs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        Object obj = names; // Object is one of the supertypes
        Iterable<String> it = names; // ArrayList IS-A Iterable
        Collection<String> col = names; // ArrayList IS-A Collection
        List<String> list = names; // ArrayList IS-A List

    }
}
