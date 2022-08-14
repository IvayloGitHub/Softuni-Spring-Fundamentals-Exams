package com.example.shoppinglistexam.web;

import com.example.shoppinglistexam.model.entity.enums.CategoryNameEnum;
import com.example.shoppinglistexam.sec.CurrentUser;
import com.example.shoppinglistexam.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ProductService productService;

    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if(currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("totalSum", productService.findTotalSumOfProducts());

        model.addAttribute("drinks",
                productService.findAllProductsByCategoryName(CategoryNameEnum.DRINK));

        model.addAttribute("food",
                productService.findAllProductsByCategoryName(CategoryNameEnum.FOOD));

        model.addAttribute("household",
                productService.findAllProductsByCategoryName(CategoryNameEnum.HOUSEHOLD));

        model.addAttribute("other",
                productService.findAllProductsByCategoryName(CategoryNameEnum.OTHER));

        return "home";
    }
}
