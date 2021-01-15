package org.vinuvicho.service;

import org.vinuvicho.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO getItemById(Long id);
    List<ItemDTO> getAllItems();
    ItemDTO createItem(ItemDTO itemDTO, Long id1, Long id);
    ItemDTO updateItem(ItemDTO itemDTO);
    void deleteItemById(Long id);

}