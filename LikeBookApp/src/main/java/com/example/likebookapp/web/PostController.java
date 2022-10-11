package com.example.likebookapp.web;

import com.example.likebookapp.model.binding.PostAddBindingModel;
import com.example.likebookapp.model.service.PostServiceModel;
import com.example.likebookapp.sec.CurrentUser;
import com.example.likebookapp.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public PostController(PostService postService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.postService = postService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")
    public String add() {
        if (currentUser.getId() ==  null) {
            return "redirect:/users/login";
        }
        return "post-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid PostAddBindingModel postAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("postAddBindingModel", postAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postAddBindingModel", bindingResult);
            return "redirect:add";
        }
        postService.addPost(modelMapper.map(postAddBindingModel, PostServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        postService.removeById(id);
        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") Long id) {
        postService.likePost(id);
        return "redirect:/";
    }

    @ModelAttribute
    public PostAddBindingModel postAddBindingModel() {
        return new PostAddBindingModel();
    }
}
