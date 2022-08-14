package com.example.spotifyplaylist.web;

import com.example.spotifyplaylist.model.entity.enums.StyleNameEnum;
import com.example.spotifyplaylist.model.view.SongViewModel;
import com.example.spotifyplaylist.sec.CurrentUser;
import com.example.spotifyplaylist.service.SongService;
import com.example.spotifyplaylist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final SongService songService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, SongService songService, UserService userService) {
        this.currentUser = currentUser;
        this.songService = songService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }
        model.addAttribute("playlist", userService.getCurrentUserPlaylist());
        model.addAttribute("duration", userService.getCurrentUserPlaylist()
                .stream().mapToInt(SongViewModel::getDuration).sum());
        model.addAttribute("pop", songService.findAllSongsByStyleName(StyleNameEnum.POP));
        model.addAttribute("rock", songService.findAllSongsByStyleName(StyleNameEnum.ROCK));
        model.addAttribute("jazz", songService.findAllSongsByStyleName(StyleNameEnum.JAZZ));
        return "home";
    }
}
