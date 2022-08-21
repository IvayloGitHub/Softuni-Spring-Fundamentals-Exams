package com.example.andreyexam.service;

import com.example.andreyexam.model.service.ItemServiceModel;
import com.example.andreyexam.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> getAllItems();

    ItemViewModel findItemById(Long id);

    void deleteItem(Long id);

}
