package com.example.musicdbexam.web;

import com.example.musicdbexam.sec.CurrentUser;
import com.example.musicdbexam.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final AlbumService albumService;

    public HomeController(CurrentUser currentUser, AlbumService albumService) {
        this.currentUser = currentUser;
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if(currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("albums", albumService.getAllAlbumsOrderedByCopiesDesc());
        model.addAttribute("totalSoldCopies", albumService.totalSoldCopies());
        return "home";
    }
}
