package com.example.shoppinglistexam.web;

import com.example.shoppinglistexam.model.binding.ProductAddBindingModel;
import com.example.shoppinglistexam.model.service.ProductServiceModel;
import com.example.shoppinglistexam.sec.CurrentUser;
import com.example.shoppinglistexam.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public ProductController(ProductService productService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")
    public String add() {
        if (currentUser.getId() == null) {
            return "redirect:/";
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);
            return "redirect:add";
        }
        productService.addProduct(modelMapper.map(productAddBindingModel, ProductServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable("id") Long id) {
        productService.buyById(id);
        return "redirect:/";
    }

    @GetMapping("/buy/all")
    public String buyAll() {
        productService.buyAll();
        return "redirect:/";
    }

    @ModelAttribute
    public ProductAddBindingModel productAddBindingModel() {
        return new ProductAddBindingModel();
    }
}
