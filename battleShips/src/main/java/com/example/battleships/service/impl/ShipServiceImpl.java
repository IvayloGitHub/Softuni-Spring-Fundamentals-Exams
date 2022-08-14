package com.example.battleships.service.impl;

import com.example.battleships.model.entity.ShipEntity;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.model.view.AttackerShipViewModel;
import com.example.battleships.model.view.DefenderShipViewModel;
import com.example.battleships.model.view.ShipViewModel;
import com.example.battleships.repository.ShipRepository;
import com.example.battleships.sec.CurrentUser;
import com.example.battleships.service.CategoryService;
import com.example.battleships.service.ShipService;
import com.example.battleships.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final CurrentUser currentUser;
    private final CategoryService categoryService;

    private final ModelMapper modelMapper;

    private final UserService userService;

    public ShipServiceImpl(ShipRepository shipRepository, CurrentUser currentUser, CategoryService categoryService, ModelMapper modelMapper, UserService userService) {
        this.shipRepository = shipRepository;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    @Override
    public void addShip(ShipServiceModel shipServiceModel) {
        ShipEntity shipEntity = modelMapper.map(shipServiceModel, ShipEntity.class);
        shipEntity.setCategory(categoryService.findCategoryByName(shipServiceModel.getCategory()));
        shipEntity.setUser(userService.findUserById(currentUser.getId()));
        shipRepository.save(shipEntity);
    }

    @Override
    public List<ShipViewModel> findAllShips() {
        return shipRepository.findAllByOrderById()
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AttackerShipViewModel> findAttackerShipsById(Long id) {
        return shipRepository.findAllByUser_Id(id)
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity, AttackerShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DefenderShipViewModel> findDefenderShipsNotWithCurrentUserId(Long id) {
        return shipRepository.findAllByUser_IdNot(id)
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity, DefenderShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void fire(Long attackerId, Long defenderId) {
        ShipEntity attacker = shipRepository.findById(attackerId)
                .orElse(null);
        ShipEntity defender = shipRepository.findById(defenderId)
                .orElse(null);

        Integer difference = attacker.getPower() - defender.getHealth();

        if (difference > 0) {
            shipRepository.deleteById(defenderId);
            return;
        }
        defender.setHealth(Math.abs(difference));
        shipRepository.save(defender);
    }
}
