package com.example.andreyexam.web;

import com.example.andreyexam.model.binding.ItemAddBindingModel;
import com.example.andreyexam.model.service.ItemServiceModel;
import com.example.andreyexam.sec.CurrentUser;
import com.example.andreyexam.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final ItemService itemService;

    public ItemController(CurrentUser currentUser, ModelMapper modelMapper, ItemService itemService) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.itemService = itemService;
    }

    @GetMapping("/add")
    public String add() {
        if (currentUser.getId() == null) {
            return "redirect:/users/login";
        }
        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ItemAddBindingModel itemAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel", bindingResult);
            return "redirect:add";
        }
        itemService.addItem(modelMapper.map(itemAddBindingModel, ItemServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        if(currentUser.getId() == null) {
            return "redirect:/users/login";
        }
        model.addAttribute("item", itemService.findItemById(id));
        return "details-item";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        itemService.deleteItem(id);
        return "redirect:/";
    }


    @ModelAttribute
    public ItemAddBindingModel itemAddBindingModel() {
        return new ItemAddBindingModel();
    }
}
