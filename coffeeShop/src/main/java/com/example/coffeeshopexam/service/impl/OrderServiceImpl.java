package com.example.coffeeshopexam.service.impl;

import com.example.coffeeshopexam.model.entity.OrderEntity;
import com.example.coffeeshopexam.model.service.OrderServiceModel;
import com.example.coffeeshopexam.model.view.OrderViewModel;
import com.example.coffeeshopexam.repository.OrderRepository;
import com.example.coffeeshopexam.sec.CurrentUser;
import com.example.coffeeshopexam.service.CategoryService;
import com.example.coffeeshopexam.service.OrderService;
import com.example.coffeeshopexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        OrderEntity order = modelMapper.map(orderServiceModel, OrderEntity.class);
        order.setEmployee(userService.findUserById(currentUser.getId()));
        order.setCategory(categoryService.findCategoryByNameEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrdersOrderedByPriceDesc() {
        return orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(orderEntity -> {
                    OrderViewModel orderViewModel = modelMapper.map(orderEntity, OrderViewModel.class);
                    orderViewModel.setImage(String.format("/images/%s.png", orderEntity.getCategory().getName().name().toLowerCase()));
                    return orderViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Integer findTotalTimeForOrdersInMin() {
        if (orderRepository.findTotalTimeForAllOrders() == null) {
            return 0;
        }
        return orderRepository.findTotalTimeForAllOrders();
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
