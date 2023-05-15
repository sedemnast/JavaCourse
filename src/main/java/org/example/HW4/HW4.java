package org.example.HW4;

import java.io.*;
import java.util.*;

public class HW4 {

    public static void main(String[] args) {
        try {
            // 1. Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
            System.out.println("1. Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader");
            String some_text = "Строка с текстом";

            // Запись строки в файл
            try (FileWriter fw = new FileWriter("example.txt")) {
                fw.write(some_text);
            }

            // Чтение строки из файла и вывод в консоль
            try (FileReader fr = new FileReader("example.txt")) {
                System.out.println("\nВ файле написано: ");
                Scanner scan = new Scanner(fr);
                while (scan.hasNextLine()) {
                    System.out.print(scan.nextLine());
                }
            }

            // 2. Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы.
            // Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
            System.out.println("\n\n2. Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы.");
            System.out.println("Разбить по строкам и вывести в консоль в формате \"Иванов И.И. 32 М\"\n");

            List<String> lines = loadLinesFromFile("/Users/sedemnast/IdeaProjects/JavaCourse/src/main/java/org/example/HW4/text.txt");

            System.out.println("В файле написано:");
            for (String line : lines) {
                String[] parts = line.split(" ");
                String surname = parts[0];
                String name = parts[1];
                String patronymic = parts[2];
                int age = Integer.parseInt(parts[3]);
                String gender = parts[4];

                String formattedLine = String.format("%s %s.%s. %d %s", surname, name.charAt(0), patronymic.charAt(0), age, gender);
                System.out.println(formattedLine);
            }

            // 3. Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возраст и пол в отдельных списках
            System.out.println("\n3. Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возраст и пол в отдельных списках");

            List<String> list_surname = new ArrayList<>();
            List<String> list_name = new ArrayList<>();
            List<String> list_second_name = new ArrayList<>();
            List<Integer> list_age = new ArrayList<>();
            List<String> list_gender = new ArrayList<>();

            for (String line : lines) {
                String[] parts = line.split(" ");
                String surname = parts[0];
                String name = parts[1];
                String patronymic = parts[2];
                int age = Integer.parseInt(parts[3]);
                String gender = parts[4];

                list_surname.add(surname);
                list_name.add(name);
                list_second_name.add(patronymic);
                list_age.add(age);
                list_gender.add(gender);
            }

            System.out.println("Список фамилий: " + list_surname);
            System.out.println("Список имен: " + list_name);
            System.out.println("Список отчеств: " + list_second_name);
            System.out.println("Список возрастов: " + list_age);
            System.out.println("Список пола: " + list_gender);

            // 4. Отсортировать по возрасту используя дополнительный список индексов
            System.out.println("\n4. Отсортировать по возрасту используя дополнительный список индексов");
            List<Integer> sortedIndices = sortIndicesByAge(list_age);

            // Вывод отсортированных данных
            System.out.println("Отсортированные данные по возрасту:");
            for (int index : sortedIndices) {
                System.out.print(list_surname.get(index) + " ");
                System.out.print(list_name.get(index) + " ");
                System.out.print(list_second_name.get(index) + " ");
                System.out.print(list_age.get(index) + " ");
                System.out.println(list_gender.get(index));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для загрузки строк из файла в список
    private static List<String> loadLinesFromFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    // Метод для сортировки списка индексов по возрасту
    private static List<Integer> sortIndicesByAge(List<Integer> ageList) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < ageList.size(); i++) {
            indices.add(i);
        }
        Collections.sort(indices, Comparator.comparingInt(ageList::get).reversed());
        return indices;
    }
}




