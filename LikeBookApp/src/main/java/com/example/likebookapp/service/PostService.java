package com.example.likebookapp.service;

import com.example.likebookapp.model.service.PostServiceModel;
import com.example.likebookapp.model.view.MyPostsViewModel;
import com.example.likebookapp.model.view.OtherPostsViewModel;

import java.util.Set;

public interface PostService {
    void addPost(PostServiceModel postServiceModel);

    Set<MyPostsViewModel> myPosts(Long id);

    void removeById(Long id);

    Set<OtherPostsViewModel> otherPosts(Long id);

    void likePost(Long id);
}
