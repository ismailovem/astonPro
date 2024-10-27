package util;

import model.Student;
import model.User;
import model.Bus;
import org.w3c.dom.ls.LSOutput;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadWrite {

    private ReadWrite() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    //метод для чтения user из файла
    public static List<Bus> readFromFileBusMethod(String path){
        List<Bus> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
            // Удаление пробелов
                line = line.trim();
                // Проверяем, что строка не пустая
                if (!line.isEmpty()) {
                    //System.out.println(line);
                    String[] parts = line.split(";");
                    if (parts.length >= 3) { // Убедимся, что есть как минимум 3 элемента
                        String number = parts[0];
                        String model = parts[1];
                        int mileage = Integer.parseInt(parts[2]);
                        Bus bus = new Bus.Builder().setNumber(number).setModel(model).setMileage(mileage).build();
                        list.add(bus);
                    } else {
                        System.out.println("файл пуст");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static List<User> readFromUserMethod(String path){
        List<User> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Удаление пробелов
                line = line.trim();
                // Проверяем, что строка не пустая
                if (!line.isEmpty()) {
                    //System.out.println(line);
                    String[] parts = line.split(";");
                    if (parts.length >= 3) { // Убедимся, что есть как минимум 3 элемента
                        String name = parts[0];
                        String password = parts[1];
                        String email = parts[2];
                        User user = new User.Builder().setName(name).setPassword(password).setEmail(email).build();
                        list.add(user);
                    } else {
                        System.out.println("файл пуст");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static List<Student> readFromStudentMethod(String path){
        List<Student> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Удаление пробелов
                line = line.trim();
                // Проверяем, что строка не пустая
                if (!line.isEmpty()) {
                    //System.out.println(line);
                    String[] parts = line.split(";");
                    if (parts.length >= 3) { // Убедимся, что есть как минимум 3 элемента
                        String groupNumber = parts[0];
                        double averageScore = Double.parseDouble(parts[1]);
                        String recordBookNumber = parts[2];
                        Student student = new Student.Builder().setGroupNumber(groupNumber)
                                .setAverageScore(averageScore).setRecordBookNumber(recordBookNumber).build();
                        list.add(student);
                    } else {
                        System.out.println("файл пуст");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    //метод для записи
    public static void writeToFileMethod(List<? extends Comparable<?>> list, String path, int size) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path,true))) {
            int i = 0;
            while (size > 0) {
                String value = list.get(i) + ";";
                System.out.println(value);
                writer.write(value);
                writer.newLine();
                i++;
                size--;
            }

        } catch (IOException e ) {
            throw new RuntimeException(e);
        }
    }


    //создает файл
    public static void makeFile(String path, String fileName){
        File file = new File(path, fileName);
        try {
            if (!file.exists()) {
                // Создаем новый файл
                if (!file.createNewFile()) {
                    System.out.println("Не удалось создать файл.");
                }
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}

