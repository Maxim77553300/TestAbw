package by.innowise.abw.dto;

import by.innowise.abw.entity.Car;

import java.util.List;

public class ListCarResponse {

    List<Car> listCars;

    public List<Car> getListCars() {
        return listCars;
    }

    public void setListCars(List<Car> listCars) {
        this.listCars = listCars;
    }
}
