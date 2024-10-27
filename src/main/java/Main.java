import model.Bus;
import model.Student;
import model.User;
import util.ReadWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static String RED = "\u001B[31m";
    private final static String BLUE = "\u001B[34m";
    private final static String RESET = "\u001B[0m"; // Сброс цвета
    private static boolean running = true;


    static List<Bus> busList = new ArrayList<>();
    static List<User> userList = new ArrayList<>();
    static List<Student> studentList = new ArrayList<>();
    static String busFilePath = "src/main/java/data/busFile.txt";
    static String userFilePath = "src/main/java/data/userFile.txt";
    static String studentFilePath = "src/main/java/data/studentFile.txt";
    static String path = "src/main/java/data/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (running) {
            int size = 0;
            size = howManyObj(scanner,size); //возвращается количество
            //System.out.println(size);

            int choise = 1;
            choise = whatObjMeth(scanner,choise); // возвращается выбор объекта
            //System.out.println(choise);

            int method = 0;
            method = howToAddMeth(scanner,method); //возвращается способ работы с данными - метод
            //System.out.println(choise + " " + method);

            if (0 == method) {
                running = false;
            }else if (method == 1) {
                readFromFile(choise);
            } else if (method == 2) {
                makeAnArrayManualy (choise, scanner,size);
            } else if (method == 3) {
                makeAnArrayRandomly(choise,size,path);
            }

            int whatToDo = 0;
            whatToDo = whatToDoMethod(scanner,whatToDo); //возвращает что будем делать с массивом

            switch (whatToDo){
                case 0:
                    running = false;
                    break;
                case 1:
                    //sort();
                    if (choise == 1) {
                        String busFileName = "busFile.txt";
                        MyQuickSort<Bus> sort = new MyQuickSort<>();
                        sort.sort(busList);
                        System.out.println(busList);
                        //ReadWrite.makeFile(path, busFileName);
                        //ReadWrite.writeToFileMethod(busList,path + busFileName,size);
                    } else if (choise == 2) {
                        String userFileName = "userFile.txt";
                        MyQuickSort<User> sort = new MyQuickSort<>();
                        sort.sort(userList);
                        System.out.println(busList);
                        ReadWrite.makeFile(path, userFileName);
                        ReadWrite.writeToFileMethod(userList,path + userFileName,size);
                    } else if (choise == 3 ) {
                        String studentFileName = "userFile.txt";
                        MyQuickSort<Student> sort = new MyQuickSort<>();
                        sort.sort(studentList);
                        System.out.println(studentList);
                        ReadWrite.makeFile(path, studentFileName);
                        ReadWrite.writeToFileMethod(studentList,path + studentFileName,size);
                    } else {
                        System.out.println("something goes wrong with the sort");
                    }
                    break;
                case 2:
                    //запись в файл
                    List<? extends Comparable<?>> list = new ArrayList<>();
                    String fileName = "";
                    if (choise == 1) {
                        list = busList;
                        fileName = "busFile.txt";
                    } else if (choise == 2) {
                        list = userList;
                        fileName = "userFile.txt";
                    } else if (choise == 3) {
                        list = studentList;
                        fileName = "studentFile.txt";
                    } else {
                        System.out.println("something goes wrong with the write");
                    }
                    //ReadWrite.makeFile(path,fileName);
                    ReadWrite.writeToFileMethod(list,path,size);
                    break;
                case 3:
                    //поиск по элементу и вывод
            }

            //ЧТЕНИЕ ИЗ ФАЙЛА  //создаем массив размера сайз //генерируем объекты выбранного класса    //если файла нет - создаем его
  //и закачиваем в файл если он пустой   //затем читаем из файла       //*           //break;


        }//running
        scanner.close();
}//main
    //=====================================================================================================
    static int howManyObj(Scanner scanner,int size){
        while (true) {
            System.out.println(BLUE + "сколько будет объектов" + RESET);
            String input = scanner.nextLine();
            try {
                size = Integer.parseInt(input);
                if (size < 1) {
                    System.out.println(RED + "введите число больше 0. Попробуйте снова." + RESET);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Некорректный ввод. Пожалуйста, введите целое число." + RESET);
            }
        }
        return size;
    }
    //====================================================================================================
     public static int whatObjMeth(Scanner scanner, int choise){
        while (running) {
            System.out.println(BLUE + "какие будут объекты" + RESET);
            System.out.println("1 - Автобусы");
            System.out.println("2 - Пользователи");
            System.out.println("3 - Студенты");
            System.out.println(BLUE + "0" + RESET + " - чтобы завершить работу программы нажмите");
            String input = scanner.nextLine();

            try {
                choise = Integer.parseInt(input);
                if (choise == 0) {
                    System.out.println(BLUE + "Вы нажали выход!!!" + RESET);
                    running = false;
                    break;
                } else if (choise < 0 || choise > 3) {
                    System.out.println("Ошибка ввода. Попробуйте снова.");// + RESET);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Ошибка ввода. введите целое число." + RESET);
            }
        }return choise;
    }
    //=============================================================================================
    public static int howToAddMeth(Scanner scanner, int method) {
        while (running) {
            System.out.println(BLUE + "как будем заполнять массив?" + RESET);
            System.out.println("1 - читать из файла");
            System.out.println("2 - создавать вручную");
            System.out.println("3 - создавать рандомно");
            System.out.println(BLUE + "0" + RESET + " - выберите чтобы завершить работу программы");
            String input = scanner.nextLine();

            try {
                method = Integer.parseInt(input);
                if (method == 0) {
                    System.out.println(BLUE + "Вы нажали выход!!!" + RESET);
                    running = false;
                    break;
                } else if (method < 0 || method > 3) {
                    System.out.println(RED + "введите число от 0 до 3" + RESET);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "ошибка ввода. введите целое число." + RESET);
            }
        }
        return method;
    }
    //================================================================================================
    public static List<Bus> addBusToList(Scanner scanner, int size) {
        while (size > 0) {
            System.out.println(BLUE + "введите номер автобуса" + RESET);
            String num = scanner.nextLine();

            System.out.println(BLUE + "введите модель автобуса" + RESET);
            String model = scanner.nextLine();

            while (true) {
                System.out.println(BLUE + "введите пробег автобуса" + RESET);
                String input = scanner.nextLine();
                try {
                    int mil = Integer.parseInt(input);
                    if (mil < 0) {
                        System.out.println(RED + "Ошибка ввода. Попробуйте снова." + RESET);
                    } else {
                        busList.add(new Bus.Builder()
                                .setNumber(num).setModel(model).setMileage(mil).build());
                        size--;
                        System.out.println("осталось ввести элементов - " + size);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(RED + "Некорректный ввод. используйте целые числа." + RESET);
                }
            }
        }

        System.out.println(busList);
        //running = false;
        return busList;
    }
    //========================================================================================================
    public static List<User> addUserToList(Scanner scanner, int size) {
        userList = new ArrayList<>();
        while (size > 0) {
            //добавить сюда проверку на числа в имени --- маску
            System.out.println("введите имя пользователя");
            String name = scanner.nextLine();

            System.out.println("введите пароль");
            String pass = scanner.nextLine();

            //добавить сюда проверку на маску почты
            System.out.println("введите email");
            String mail = scanner.nextLine();

            userList.add(new User.Builder()
                    .setName(name).setPassword(pass).setEmail(mail).build());
            size--;
            System.out.println("осталось ввести элементов - " + size);
        }
        return userList;
    }
    //============================================================================
    public static List<Student> addStudentToList(Scanner scanner, int size){
        System.out.println("введите группу студента");
        String stGroup = scanner.nextLine();
        System.out.println("введите номер зачетки студента");
        String recBookNum = scanner.nextLine();

        while (true) {
            System.out.println("введите средний балл студента");
            String input = scanner.nextLine();
            try{
                double averScore = Double.parseDouble(input);
                if (averScore < 0.0) {
                    System.out.println(RED + "Ошибка ввода. Попробуйте снова." + RESET);
                } else {
                    studentList.add(new Student.Builder()
                            .setGroupNumber(stGroup).setRecordBookNumber(recBookNum).setAverageScore(averScore).build());
                    size--;
                    System.out.println("осталось ввести элементов - " + size);
                    break;
                }
            }catch (NumberFormatException e) {
                System.out.println(RED + "Некорректный ввод. используйте целые числа." + RESET);
            }
        }
        System.out.println(studentList);
        return studentList;
    }
    //==========================================================================
    public static void readFromFile(int choise){
        if (choise == 1) {
            List<Bus> buses = ReadWrite.readFromFileBusMethod(busFilePath);
            for (Bus bus : buses) {
                System.out.println(bus);
            }
        } else if(choise == 2) {
            List<User> users = ReadWrite.readFromUserMethod(userFilePath);
            for (User user : users) {
                System.out.println(user);
            }
        } else if(choise == 3) {
            List<Student> students = ReadWrite.readFromStudentMethod(studentFilePath);
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    //===================================================================
    public static void makeAnArrayManualy (int choise,Scanner scanner,int size){
        if (choise == 1) {
            //String busFileName = "busFile.txt";
            //ReadWrite.makeFile(path, busFileName);
            addBusToList(scanner,size);
            System.out.println(busList);
        } else if (choise == 2) {  //User создаем юзеров руками
            //String userFileName = "userFile.txt";
            //ReadWrite.makeFile(path, userFileName);
            addUserToList(scanner,size);
            System.out.println(userList);
            //running = false;
            //break;
        } else if (choise == 3) {
            /*String path = "src/main/java/data/";
            String userFileName = "studentFile.txt";*/
            //ReadWrite.makeFile(path, userFileName);
            addStudentToList(scanner,size);
            System.out.println(studentList);
        }
    }
    //=================================================================================
    public static void makeAnArrayRandomly (int choise,int size, String path){
        //String writePath = "src/main/java/data/";
        if (choise == 1) {
            String busFileName = "busFile.txt";
            String absPath = path + busFileName;
            busList = ArrayGenerator.generateRandomBuses(size);
            //ReadWrite.makeFile(path, busFileName);
            ReadWrite.writeToFileMethod(busList,absPath,size);
        } else if (choise == 2) {
            String userFileName = "userFile.txt";
            String absPath = path + userFileName;
            userList = ArrayGenerator.generateRandomUsers(size);
            //ReadWrite.makeFile(path, userFileName);
            ReadWrite.writeToFileMethod(userList,absPath,size);
        } else if (choise == 3) {
            String studentFileName = "studentFile.txt";
            String absPath = path + studentFileName;
            studentList = ArrayGenerator.generateRandomStudents(size);
            //ReadWrite.makeFile(path, studentFileName);
            ReadWrite.writeToFileMethod(studentList,absPath,size);
        }
    }
    //===============================================================================
    public static int whatToDoMethod(Scanner scanner,int sortChoise){
        while(running) {
            System.out.println(BLUE + "что будем делать с данными" + RESET);
            System.out.println("1 - сортировать и выводить");
            System.out.println("2 - записывать в файл");
            System.out.println("3 - искать и выводить");
            System.out.println(BLUE + "0" + RESET + " - выберите чтобы завершить работу программы");
            String input = scanner.nextLine();

            try {
                sortChoise = Integer.parseInt(input);
                if (sortChoise == 0) {
                    System.out.println(BLUE + "Вы нажали выход!!!" + RESET);
                    running = false;
                    break;
                } else if (sortChoise < 0 || sortChoise > 3) {
                    System.out.println("Ошибка ввода. Попробуйте снова.");// + RESET);
                } else {
                    return sortChoise;
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Ошибка ввода. введите целое число." + RESET);
            }
        }
        return sortChoise;
    }




}//main



//1. читать из файла
//          - открываем файл
//          - генерируем туда данные - записываем
//          - тут же считываем и показываем
//          - сортируем показываем




























            /*System.out.println("Выберите класс для сортировки (1: model.Bus, 2: model.User, 3: model.Student, 0: Выход): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                running = false;
                continue;
            }

            System.out.print("Введите количество объектов для генерации: ");
            int size = scanner.nextInt();

            List<? extends Comparable<?>> dataList = null;
            switch (choice) {
                case 1:
                    dataList = new ArrayList<>(ArrayGenerator.generateRandomBuses(size));
                    break;
                case 2:
                    dataList = new ArrayList<>(ArrayGenerator.generateRandomUsers(size));
                    break;
                case 3:
                    dataList = new ArrayList<>(ArrayGenerator.generateRandomStudents(size));
                    break;
            }*/


