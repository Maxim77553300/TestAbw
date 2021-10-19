package by.innowise.abw.service;

import by.innowise.abw.dto.AddCarRequest;
import by.innowise.abw.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CarService {
    List<Car> findAllCar();

    List<Car> findAllCarByBrand(AddCarRequest addCarRequest);

    void addCar(AddCarRequest addCarRequest);

    List<Car> findAllCarByPrice(AddCarRequest addCarRequest);

    void removeAd(AddCarRequest addCarRequest);

    List<String> findAllBrands();
}
