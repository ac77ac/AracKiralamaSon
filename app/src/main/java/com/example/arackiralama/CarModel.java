package com.example.arackiralama;
import java.util.ArrayList;
import java.util.List;

public class CarModel {
    private List<Car> cars;

    public CarModel() {
        this.cars = new ArrayList<>();
    }

    public void add(String brand, String model, String year, String color) {
        Car car = new Car(brand, model, year, color);
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<CarModel.Car> getAllCars() {
        return cars;

    }

    public static class Car {
        private String brand;
        private String model;
        private String year;
        private String color;

        public Car(String brand, String model, String year, String color) {
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.color = color;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public String getYear() {
            return year;
        }

        public String getColor() {
            return color;
        }
    }
}