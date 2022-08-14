package com.example.musicdbexam.web;

import com.example.musicdbexam.model.binding.AlbumAddBindingModel;
import com.example.musicdbexam.model.service.AlbumServiceModel;
import com.example.musicdbexam.sec.CurrentUser;
import com.example.musicdbexam.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")
    public String add(){
        if(currentUser.getId() == null) {
            return "redirect:/";
        }
        return "add-album";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid AlbumAddBindingModel albumAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel", bindingResult);
            return "redirect:add";
        }
        albumService.addAlbum(modelMapper.map(albumAddBindingModel, AlbumServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        albumService.delete(id);
        return "redirect:/";
    }

    @ModelAttribute
    public AlbumAddBindingModel albumAddBindingModel(){
        return new AlbumAddBindingModel();
    }
}
