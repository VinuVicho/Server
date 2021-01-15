package org.vinuvicho.mapper;

import org.vinuvicho.dto.CarDTO;
import org.vinuvicho.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarToCarDTOMapper {
    public Car toEntity(final CarDTO carDTO){
        final Car car = new Car();

        car.setId(carDTO.getId());
        car.setName(carDTO.getName());
        car.setType(carDTO.getType());

        return car;
    }

    public CarDTO toDTO(final Car car){
        final CarDTO carDTO = new CarDTO();

        carDTO.setId(car.getId());
        carDTO.setName(car.getName());
        carDTO.setType(car.getType());

        return carDTO;
    }
}