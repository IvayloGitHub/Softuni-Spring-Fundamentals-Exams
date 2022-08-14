package com.example.battleships.service;

import com.example.battleships.model.entity.ShipEntity;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.model.view.AttackerShipViewModel;
import com.example.battleships.model.view.DefenderShipViewModel;
import com.example.battleships.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {
    void addShip(ShipServiceModel shipServiceModel);

    List<ShipViewModel> findAllShips();

    List<AttackerShipViewModel> findAttackerShipsById(Long id);

    List<DefenderShipViewModel> findDefenderShipsNotWithCurrentUserId(Long id);

    void fire(Long attackerId, Long defenderId);
}
