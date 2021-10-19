package by.innowise.abw.dto;

import by.innowise.abw.entity.Car;

import java.util.List;

public class ListCarResponse {

    List<Car> listCar;

    public List<Car> getListCar() {
        return listCar;
    }

    public void setListCar(List<Car> listCar) {
        this.listCar = listCar;
    }
}
