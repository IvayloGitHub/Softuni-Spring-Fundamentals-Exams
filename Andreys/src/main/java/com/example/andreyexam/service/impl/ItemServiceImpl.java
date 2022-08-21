package com.example.andreyexam.service.impl;

import com.example.andreyexam.model.entity.ItemEntity;
import com.example.andreyexam.model.service.ItemServiceModel;
import com.example.andreyexam.model.view.ItemViewModel;
import com.example.andreyexam.repository.ItemRepository;
import com.example.andreyexam.service.CategoryService;
import com.example.andreyexam.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        ItemEntity itemEntity = modelMapper.map(itemServiceModel, ItemEntity.class);
        itemEntity.setCategory(categoryService.findCategoryByName(itemServiceModel.getCategory()));
        itemEntity.setGender(itemServiceModel.getGender());
        itemRepository.save(itemEntity);
    }

    @Override
    public List<ItemViewModel> getAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(itemEntity -> {
                    ItemViewModel itemViewModel = modelMapper.map(itemEntity, ItemViewModel.class);
                    itemViewModel.setPicture(String.format("/image/%s-%s.jpg", itemEntity.getGender(), itemEntity.getCategory().getName()));
                    return itemViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findItemById(Long id) {
        return itemRepository.findById(id)
                .map(itemEntity -> {
                    ItemViewModel itemViewModel = modelMapper.map(itemEntity, ItemViewModel.class);
                    itemViewModel.setPicture(String.format("/image/%s-%s.jpg",
                            itemEntity.getGender(), itemEntity.getCategory().getName()));
                    return itemViewModel;
                })
                .orElse(null);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
