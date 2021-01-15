package org.vinuvicho.service;

import org.vinuvicho.dto.CarDTO;

import java.util.List;

public interface CarService {
    CarDTO getCarById(Long id);
    List<CarDTO> getAllCars();
    CarDTO createCar(CarDTO carDTO, Long id);
    CarDTO updateCar(CarDTO carDTO);
    void deleteCarById(Long id);

}
