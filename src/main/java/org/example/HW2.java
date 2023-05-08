package org.example;

public class HW2 {
    public static void main(String[] args) {
        print_power("Основание 5, степень 3, результат равен");
        print_power("Основание 10, степень 2, результат равен");
        print_power("Основание 2, степень 10, результат равен");

        // Measure time difference between String and StringBuilder
        long start, end, duration;

        // String class
        start = System.currentTimeMillis();
        print_updated_text();
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Time taken by String: " + duration + "ms");

        // StringBuilder class
        start = System.currentTimeMillis();
        print_updated_text_builder();
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Time taken by StringBuilder: " + duration + "ms");
    }

    private static void print_power(String s) {
        String[] parts = s.split("[^\\d]+");
        int base = Integer.parseInt(parts[1]);
        int exponent = Integer.parseInt(parts[2]);
        double result = Math.pow(base, exponent);
        System.out.println(s + " " + result);
    }

    private static void print_updated_text() {
        String originalText = "Свет от солнца, природа, которая окружает нас, и все, что мы видим, слышим и чувствуем, создают красоту и гармонию в мире. Люди также могут создавать красоту, используя искусство и музыку. Мы можем рисовать, играть на инструментах, танцевать и петь. Иногда красота может привести к счастью и радости, иногда она может вызвать грусть или тоску. Но в любом случае, она оставляет в наших сердцах след навсегда.";
        String updatedText = originalText.replace("красоту", "восторг");
        System.out.println(updatedText);
    }
    
    private static void print_updated_text_builder() {
        StringBuilder originalText = new StringBuilder("Свет от солнца, природа, которая окружает нас, и все, что мы видим, слышим и чувствуем, создают красоту и гармонию в мире. Люди также могут создавать красоту, используя искусство и музыку. Мы можем рисовать, играть на инструментах, танцевать и петь. Иногда красота может привести к счастью и радости, иногда она может вызвать грусть или тоску. Но в любом случае, она оставляет в наших сердцах след навсегда.");
        int index = originalText.indexOf("красоту");
        while (index != -1) {
        index = originalText.indexOf("красоту", index + 1);
    }
    System.out.println(originalText.toString());
}}
