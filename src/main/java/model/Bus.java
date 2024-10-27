package model;

public class Bus implements Comparable<Bus> {
    private String number;
    private String model;
    private Integer mileage;

    private Bus(Builder builder) {
        this.number = builder.number;
        this.model = builder.model;
        this.mileage = builder.mileage;
    }

    public String getNumber() { return number; }
    public String getModel() { return model; }
    public int getMileage() { return mileage; }

    @Override
    public int compareTo(Bus other) {
        return this.mileage - other.mileage; // Сравнение по пробегу
    }

    @Override
    public String toString() {
        return number + ";" + model + ";" + mileage +";";
    }

    public static class Builder {
        private String number;
        private String model;
        private int mileage;

        public Builder setNumber(String number) {
            this.number = number;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() {
            return new Bus(this);
        }
    }
}
