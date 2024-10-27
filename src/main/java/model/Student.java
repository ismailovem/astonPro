package model;

public class Student implements Comparable<Student> {
    private String groupNumber;
    private Double averageScore;
    private String recordBookNumber;

    private Student(Builder builder) {
        this.groupNumber = builder.groupNumber;
        this.averageScore = builder.averageScore;
        this.recordBookNumber = builder.recordBookNumber;
    }

    public String getGroupNumber() { return groupNumber; }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.averageScore, other.averageScore); // Сравнение по среднему баллу
    }

    @Override
    public String toString() {
        return groupNumber + ";" + averageScore + ";" + recordBookNumber + ";";
    }

    public static class Builder {
        private String groupNumber;
        private double averageScore;
        private String recordBookNumber;

        public Builder setGroupNumber(String groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        public Builder setAverageScore(double averageScore) {
            this.averageScore = averageScore;
            return this;
        }

        public Builder setRecordBookNumber(String recordBookNumber) {
            this.recordBookNumber = recordBookNumber;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}