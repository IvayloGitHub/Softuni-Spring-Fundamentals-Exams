package com.example.likebookapp.web;

import com.example.likebookapp.sec.CurrentUser;
import com.example.likebookapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final PostService postService;

    public HomeController(CurrentUser currentUser, PostService postService) {
        this.currentUser = currentUser;
        this.postService = postService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("myPosts", postService.myPosts(currentUser.getId()));
        model.addAttribute("otherPosts", postService.otherPosts(currentUser.getId()));
        return "home";
    }
}
