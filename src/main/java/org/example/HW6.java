package org.example;

import java.util.*;

public class HW6 {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
//            return o1 - o2;
            }
        };

        MyTreeSet myTreeSet = new MyTreeSet(comparator);

        for (int i = 0; i < 5; i++) {
            myHashSet.add(new Random().nextInt(10));
            myTreeSet.add(new Random().nextInt(10));
        }

        System.out.println(myHashSet.contains(7));
        System.out.println(myHashSet.toString());
        Iterator<Integer> iterator = myTreeSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();
        System.out.println(myHashSet.getItem(3));
    }
}

class MyHashSet {
    private static final Object OBJECT = new Object();
    private LinkedHashMap<Integer, Object> hashMap = new LinkedHashMap<>();

    public boolean add(int num) {
        return hashMap.put(num, OBJECT) == null;
    }

    public boolean contains(int num) {
        return hashMap.containsKey(num);
    }

    public Object[] toArray() {
        return hashMap.keySet().toArray();
    }

    public Iterator<Integer> iterator() {
        return hashMap.keySet().iterator();
    }

    public Integer getItem(int index) {
        return (Integer) toArray()[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}

class MyTreeSet {
    private Comparator<Integer> comparator;
    private TreeMap<Integer, Object> treeMap = new TreeMap<>();

    public MyTreeSet(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    public boolean add(int num) {
        return treeMap.put(num, null) == null;
    }

    public boolean contains(int num) {
        return treeMap.containsKey(num);
    }

    public Object[] toArray() {
        return treeMap.keySet().toArray();
    }

    public Iterator<Integer> iterator() {
        return treeMap.keySet().iterator();
    }

    public Integer getItem(int index) {
        return (Integer) toArray()[index];
    }
}
