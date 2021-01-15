package org.vinuvicho.service.impl;

import org.vinuvicho.dto.ItemDTO;
import org.vinuvicho.exception.ServiceException;
import org.vinuvicho.mapper.ItemToItemDTOMapper;
import org.vinuvicho.repository.CarRepository;
import org.vinuvicho.repository.ItemRepository;
import org.vinuvicho.repository.UserRepository;
import org.vinuvicho.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemToItemDTOMapper itemToItemDTOMapper;

    @Override
    public ItemDTO getItemById(final Long id) {
        return itemToItemDTOMapper.toDTO(itemRepository.getItemById(id));
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return itemRepository.getAllItems().stream()
                .map(e -> itemToItemDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO createItem(final ItemDTO itemDTO, Long id1, Long id) {
        if(itemDTO.getId() != null) {
            throw new ServiceException(400, "Item shouldn't have an id ", null);
        }

        if(UserRepository.checkUserId(id)){
            if(!CarRepository.checkCarId(id)){
                throw new ServiceException(404, "User not found ", null);
            }
        }
        else { throw new ServiceException(404, "User not found ", null);}

        return itemToItemDTOMapper.toDTO(itemRepository.createItem(itemToItemDTOMapper.toEntity(itemDTO)));
    }

    @Override
    public ItemDTO updateItem(final ItemDTO itemDTO) {
        if(itemDTO.getId() == null){
            throw new ServiceException(400, "Item doesn't have an id ", null);
        }
        return itemToItemDTOMapper.toDTO(itemRepository.updateItem(itemToItemDTOMapper.toEntity(itemDTO)));
    }

    @Override
    public void deleteItemById(final Long id) {
        itemRepository.deleteItemById(id);
    }
}