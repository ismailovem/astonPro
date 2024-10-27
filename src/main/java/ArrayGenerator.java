import model.Bus;
import model.Student;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayGenerator {
    public static Random random = new Random();

    public static List<Bus> generateRandomBuses(int size) {
        List<Bus> buses = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Bus bus = new Bus.Builder()
                    .setNumber("Number" + i)
                    .setModel("Model" + random.nextInt(10))
                    .setMileage(random.nextInt(50000))
                    .build();
            buses.add(bus);
        }
        return buses;
    }

    public static List<User> generateRandomUsers(int size) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            User user = new User.Builder()
                    .setName("User" + i)
                    .setPassword("Password" + i)
                    .setEmail("email" + i + "@example.com")
                    .build();
            users.add(user);
        }
        return users;
    }

    public static List<Student> generateRandomStudents(int size) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Student student = new Student.Builder()
                    .setGroupNumber("Group" + random.nextInt(5))
                    .setAverageScore(random.nextDouble() * 5.0)
                    .setRecordBookNumber("RecordBook" + i)
                    .build();
            students.add(student);
        }
        return students;
    }
}
