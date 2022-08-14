package com.example.battleships.web;

import com.example.battleships.model.binding.ShipAddBindingModel;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.sec.CurrentUser;
import com.example.battleships.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {
    private final CurrentUser currentUser;
    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public ShipController(CurrentUser currentUser, ShipService shipService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add() {
        if(currentUser.getId() == null) {
            return "redirect:/";
        }
        return "ship-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ShipAddBindingModel shipAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);
            return "redirect:add";
        }
        shipService.addShip(modelMapper.map(shipAddBindingModel, ShipServiceModel.class));
        return "redirect:/";
    }

    @PostMapping("/fire")
    public String fire(@RequestParam("attackerId") Long attackerId, @RequestParam("defenderId") Long defenderId) {
        shipService.fire(attackerId, defenderId);
        return "redirect:/";
    }

    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel(){
        return new ShipAddBindingModel();
    }
}
