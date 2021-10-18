package by.innowise.abw.controller;

import by.innowise.abw.dto.AddCarRequest;
import by.innowise.abw.dto.ListCarResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public interface CarController {

    ListCarResponse findAllCar();

    ResponseEntity<?> createAd(AddCarRequest addCarRequest);

    ListCarResponse findAllCarByBrand(AddCarRequest addCarRequest);

    ListCarResponse findAllCarByPrice(AddCarRequest addCarRequest);
}
