package by.innowise.abw.controller;

import by.innowise.abw.dto.AddCarRequest;
import by.innowise.abw.dto.ListBrandResponse;
import by.innowise.abw.dto.ListCarResponse;
import by.innowise.abw.entity.Car;
import by.innowise.abw.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarControllerImpl implements CarController {

    CarService carService;

    public CarControllerImpl(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/findAllCar")
    @Override
    public ListCarResponse findAllCar() {
        List<Car> allCar = carService.findAllCar();
        ListCarResponse listCarResponse = new ListCarResponse();
        listCarResponse.setListCar(allCar);
        return listCarResponse;
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<?> createAd(@RequestBody AddCarRequest addCarRequest) {
        carService.addCar(addCarRequest);
        return ResponseEntity.status(202).build();
    }

    @PostMapping("/removeAd")
    @Override
    public ResponseEntity<?> removeAd(@RequestBody AddCarRequest addCarRequest) {
        carService.removeAd(addCarRequest);
        return ResponseEntity.status(202).build();
    }


    @GetMapping("/findAllCarByBrand")
    @Override
    public ListCarResponse findAllCarByBrand(@RequestBody AddCarRequest addCarRequest){
        List<Car> allFilterCar = carService.findAllCarByBrand(addCarRequest);

        ListCarResponse listCarResponse = new ListCarResponse();
        listCarResponse.setListCar(allFilterCar);

        return listCarResponse;
    }


    @GetMapping("/findAllCarByPrice")
    @Override
    public ListCarResponse findAllCarByPrice(@RequestBody AddCarRequest addCarRequest){
        List<Car> allFilterCar = carService.findAllCarByPrice(addCarRequest);

        ListCarResponse listCarResponse = new ListCarResponse();
        listCarResponse.setListCar(allFilterCar);

        return listCarResponse;
    }

    @GetMapping("/showBrands")
    @Override
    public ListBrandResponse showBrands(){
        List<String> allBrands = carService.findAllBrands();
        ListBrandResponse listBrandResponse = new ListBrandResponse();
        listBrandResponse.setListBrands(allBrands);


        return listBrandResponse;
    }


}