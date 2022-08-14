package com.example.coffeeshopexam.web;

import com.example.coffeeshopexam.sec.CurrentUser;
import com.example.coffeeshopexam.service.OrderService;
import com.example.coffeeshopexam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserService userService;
    private final OrderService orderService;
    private final CurrentUser currentUser;

    public HomeController(UserService userService, OrderService orderService, CurrentUser currentUser) {
        this.userService = userService;
        this.orderService = orderService;
        this.currentUser = currentUser;
    }


    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.getId() == null) {

            return "index";
        }

        model.addAttribute("orders", orderService.findAllOrdersOrderedByPriceDesc());
        model.addAttribute("totalMinutes", orderService.findTotalTimeForOrdersInMin());
        model.addAttribute("employees", userService.orderEmploysByTheCountOfTheirOrders());
        return "home";
    }

}
