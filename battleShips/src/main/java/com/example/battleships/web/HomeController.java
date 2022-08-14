package com.example.battleships.web;

import com.example.battleships.sec.CurrentUser;
import com.example.battleships.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ShipService shipService;

    public HomeController(CurrentUser currentUser, ShipService shipService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }
        model.addAttribute("allShips", shipService.findAllShips());
        model.addAttribute("attackerShips", shipService.findAttackerShipsById(currentUser.getId()));
        model.addAttribute("defenderShips", shipService.findDefenderShipsNotWithCurrentUserId(currentUser.getId()));
        return "home";
    }
}
