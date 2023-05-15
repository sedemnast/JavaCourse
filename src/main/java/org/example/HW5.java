package org.example;

import java.util.HashMap;
import java.util.Map;

public class HW5 {
    public static void main(String[] args) {
        // Шаг 1: Создание множества (Map) с ключами и значениями строкового типа
        Map<String, String> firstMap = new HashMap<>();

        // Шаг 2: Добавление шести элементов в первое множество
        firstMap.put("ключ1", "значение1");
        firstMap.put("ключ2", "значение2");
        firstMap.put("ключ3", "значение3");
        firstMap.put("ключ4", "значение4");
        firstMap.put("ключ5", "значение5");
        firstMap.put("ключ6", "значение6");

        // Шаг 3: Вывод значений первого множества в консоль
        System.out.println("Значения первого множества:");
        for (String value : firstMap.values()) {
            System.out.println(value);
        }

        // Шаг 4: Добавление символа "!" ко всем значениям первого множества
        for (Map.Entry<String, String> entry : firstMap.entrySet()) {
            String newValue = entry.getValue() + "!";
            entry.setValue(newValue);
        }

        // Шаг 5: Создание второго множества с таким же обобщением
        Map<String, String> secondMap = new HashMap<>();

        // Шаг 6: Добавление ключей и значений во второе множество (частично совпадающих с первым множеством)
        secondMap.put("ключ3", "новое значение3");
        secondMap.put("ключ4", "новое значение4");
        secondMap.put("ключ5", "новое значение5");
        secondMap.put("ключ6", "новое значение6");

        // Шаг 7: Объединение значений второго и первого множеств, если ключи совпадают
        for (Map.Entry<String, String> entry : secondMap.entrySet()) {
            String key = entry.getKey();
            if (firstMap.containsKey(key)) {
                String combinedValue = firstMap.get(key) + " " + entry.getValue();
                firstMap.put(key, combinedValue);
            }
        }

        // Шаг 8: Вывод результата объединения в консоль
        System.out.println("\nРезультат объединения множеств:");
        for (Map.Entry<String, String> entry : firstMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }
}

