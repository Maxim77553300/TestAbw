package by.innowise.abw.service;

import by.innowise.abw.dto.AddCarRequest;
import by.innowise.abw.entity.Car;
import by.innowise.abw.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    CarRepository repository;

    public CarServiceImpl(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Car> findAllCar() {

        return repository.findAll();
    }

    @Override
    public List<Car> findAllCarByBrand(AddCarRequest addCarRequest) {
        System.out.println(addCarRequest.getBrand());
        List<Car> listAllCars = repository.findAll();
        List<Car> listFilter = listAllCars.stream().filter(a -> a.getBrand().equals(addCarRequest.getBrand())).collect(Collectors.toList());
        System.out.println(listFilter.toString());
        return listFilter;
    }

    @Override
    public void removeAd(AddCarRequest addCarRequest){
        String name = addCarRequest.getName();
        repository.deleteById(addCarRequest.getId());
        System.out.println("Add was " + name + " removed ");
    }

    @Override
    public void addCar(AddCarRequest addCarRequest) {
        repository.save(mapAddCarRequestToCar(addCarRequest));
    }

    @Override
    public List<Car> findAllCarByPrice(AddCarRequest addCarRequest) {
        List<Car> listCars = repository.findAll();
        Collections.sort(listCars,new PriceComparator());
        System.out.println(listCars.toString());
        return listCars;
    }

    private Car mapAddCarRequestToCar(AddCarRequest addCarRequest) {
        Car car = new Car();
        car.setName(addCarRequest.getName());
        car.setBrand(addCarRequest.getBrand());
        car.setDescription(addCarRequest.getDescription());
        car.setPrice(addCarRequest.getPrice());
        return car;
    }

    @Override
    public List<String> findAllBrands(){
        List<Car> listCars = repository.findAll();
        List<String> listBrands = new ArrayList<>();
        Set<String> brands = new HashSet<>();
        for (int i = 0;i< listCars.size();i++){
            brands.add(listCars.get(i).getBrand());
        }
        Iterator<String> it = brands.iterator();
        while (it.hasNext()){
            listBrands.add(it.next());
        }
        return listBrands;
    }



}
