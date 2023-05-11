package org.example;

import java.util.*;

public class HW3 {
    public static void main(String[] args) {
        // 1. Дан произвольный список целых чисел, удалить из него четные числа:
        ArrayList<Integer> list1 = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int val = random.nextInt(100);
            list1.add(val);
        }

        System.out.println("1. Исходный список: " + list1);

        Iterator<Integer> iterator = list1.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println("   Список без четных чисел: " + list1);
        printDivider();

        // 2. Удаление четных чисел из списка:
        ArrayList<Integer> list2 = formArrayWithRandomTen(new ArrayList<>(), 10, 25);
        System.out.println("2. Исходный список: " + list2);

        list2.removeIf(number -> number % 2 == 0);

        System.out.println("   Список без четных чисел: " + list2);
        printDivider();

        // 3. Найти минимальное, максимальное и среднее значение в списке:
        ArrayList<Integer> list3 = formArrayWithRandomTen(new ArrayList<>(), 10, 25);
        System.out.println("3. Исходный список: " + list3);

        Integer max = Collections.max(list3);
        Integer min = Collections.min(list3);
        double avg = list3.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        System.out.println("   Максимальное значение: " + max);
        System.out.println("   Минимальное значение: " + min);
        System.out.println("   Среднее значение: " + avg);
        printDivider();

        // 4. Объединение двух списков, исключая повторяющиеся элементы:
        ArrayList<Integer> list4_0 = formArrayWithRandomTen(new ArrayList<>(), 10, 25);
        ArrayList<Integer> list4_1 = formArrayWithRandomTen(new ArrayList<>(), 10, 25);
        System.out.println("4. Первый список: " + list4_0);
        System.out.println("   Второй список: " + list4_1);

        Set<Integer> uniqueSet = new HashSet<>(list4_0);
        uniqueSet.addAll(list4_1);
        ArrayList<Integer> mergedList = new ArrayList<>(uniqueSet);

        System.out.println("   Объединенный список без повторений: " + mergedList);
        printDivider();

        // 5. Создание ArrayList и добавление нуля 10000 раз:
        ArrayList<Integer> arrayList = new ArrayList<>();

        long beginArrayList = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0);
        }
        long endArrayList = System.nanoTime();
        long resultArrayList = endArrayList - beginArrayList;

        System.out.println("5. ArrayList с 10000 нулями");
        printDivider();

        // 6. Повтор пятого пункта, но с LinkedList:
        LinkedList<Integer> linkedList = new LinkedList<>();

        long beginLinkedList = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(0);
        }
        long endLinkedList = System.nanoTime();
        long resultLinkedList = endLinkedList - beginLinkedList;

        System.out.println("6. LinkedList с 10000 нулями");
        printDivider();

        // 7. Сравнение время работы пятого и шестого пунктов:
        System.out.println("7. Сравнение времени работы ArrayList и LinkedList:");
        System.out.println("   Время работы ArrayList: " + resultArrayList + " нс");
        System.out.println("   Время работы LinkedList: " + resultLinkedList + " нс");
    }

    private static void printDivider() {
        System.out.println("=".repeat(40));
    }

    private static ArrayList<Integer> formArrayWithRandomTen(ArrayList<Integer> inArray, int length, int bound) {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(bound);
            inArray.add(num);
        }
        return inArray;
    }
}


