package org.vinuvicho.repository;

import org.vinuvicho.entity.Car;
import org.vinuvicho.entity.User;
import org.vinuvicho.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository {

    @PostConstruct
    public void init(){
        savedCars = new ArrayList<>();
    }

    private static Long lastId = 1L;
    private static List<Car> savedCars;

    public Car getCarById(final Long id){
        return savedCars.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Car with id: " + id + " not found ", null));
    }

    public List<Car> getAllCars(){
        return savedCars;
    }

    public Car createCar(final Car car){
        if(car.getId() != null){
            throw new ServiceException(400, "Car shouldn't have an id ", null);
        }
        ++lastId;
        car.setId(lastId);
        savedCars.add(car);
        return car;
    }

    public Car updateCar(final Car car){
        if(car.getId() == null){
            throw new ServiceException(400, "User shouldn't have an id ", null);
        }

        final Car savedCar = getCarById(car.getId());


        savedCar.setType(car.getType());
        savedCar.setName(car.getName());

        return savedCar;
    }

    public void deleteCarById(final Long id){
        if(id == null){
            throw new ServiceException(400, "Id isn't specified", null);
        }

        savedCars.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Car with id: " + id + " not found ", null));

        savedCars = savedCars.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());
    }

    public static boolean checkCarId(Long id) {
        if(!savedCars.isEmpty()) {
            for (Car car: savedCars) {
                if (car.getId().equals(id)) return true;
            }
        }
        return false;
    }
}