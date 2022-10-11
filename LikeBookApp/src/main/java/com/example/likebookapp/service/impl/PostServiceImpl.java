package com.example.likebookapp.service.impl;

import com.example.likebookapp.model.entity.PostEntity;
import com.example.likebookapp.model.entity.UserEntity;
import com.example.likebookapp.model.service.PostServiceModel;
import com.example.likebookapp.model.view.MyPostsViewModel;
import com.example.likebookapp.model.view.OtherPostsViewModel;
import com.example.likebookapp.repository.PostRepository;
import com.example.likebookapp.sec.CurrentUser;
import com.example.likebookapp.service.MoodService;
import com.example.likebookapp.service.PostService;
import com.example.likebookapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final MoodService moodService;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, MoodService moodService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.moodService = moodService;
    }

    @Override
    public void addPost(PostServiceModel postServiceModel) {
        PostEntity postEntity = modelMapper.map(postServiceModel, PostEntity.class);
        postEntity.setUser(userService.findUserById(currentUser.getId()));
        postEntity.setMood(moodService.findMoodByName(postServiceModel.getMood()));
        postRepository.save(postEntity);
    }

    @Override
    public Set<MyPostsViewModel> myPosts(Long id) {
        return postRepository.findByUser_Id(id)
                .stream()
                .map(postEntity -> {
                    MyPostsViewModel myPostsViewModel = modelMapper.map(postEntity, MyPostsViewModel.class);
                    myPostsViewModel.setName(postEntity.getMood().getName());
                    return myPostsViewModel;
                })
                .collect(Collectors.toSet());
    }

    @Override
    public void removeById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Set<OtherPostsViewModel> otherPosts(Long id) {
        return postRepository.findByUser_IdNot(id)
                .stream()
                .map(postEntity -> {
                    OtherPostsViewModel otherPostsViewModel = modelMapper.map(postEntity, OtherPostsViewModel.class);
                    otherPostsViewModel.setName(postEntity.getMood().getName());
                    otherPostsViewModel.setUsername(postEntity.getUser().getUsername());
                    return otherPostsViewModel;
                })
                .collect(Collectors.toSet());
    }

    @Override
    public void likePost(Long id) {
    PostEntity postEntity = postRepository.findById(id).orElse(null);
    UserEntity userEntity = userService.findUserById(currentUser.getId());
    postEntity.getUserLikes().add(userEntity);
    postRepository.save(postEntity);
    }
}
