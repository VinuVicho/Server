package org.vinuvicho.repository;

import org.vinuvicho.entity.Item;
import org.vinuvicho.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ItemRepository {

    @PostConstruct
    public void init(){
        savedItems = new ArrayList<>();
    }

    private static Long lastId = 1L;
    private List<Item> savedItems;

    public Item getItemById(final Long id){
        return savedItems.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Item with id: " + id + " not found ", null));
    }

    public List<Item> getAllItems(){
        return savedItems;
    }

    public Item createItem(final Item item){
        if(item.getId() != null){
            throw new ServiceException(400, "Item shouldn't have an id ", null);
        }
        ++lastId;
        item.setId(lastId);
        savedItems.add(item);
        return item;
    }

    public Item updateItem(final Item item){
        if(item.getId() == null){
            throw new ServiceException(400, "User shouldn't have an id ", null);
        }

        final Item savedItem = getItemById(item.getId());

        savedItem.setName(item.getName());
        savedItem.setPrice(item.getPrice());

        return savedItem;
    }

    public void deleteItemById(final Long id){
        if(id == null){
            throw new ServiceException(400, "Id isn't specified", null);
        }

        savedItems.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Item with id: " + id + " not found ", null));

        savedItems = savedItems.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());
    }
}